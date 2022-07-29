package com.alkemy.disney.repository.Specifications;


import com.alkemy.disney.dto.CharacterFiltersDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.MovieEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterSpecification {

    public Specification<CharacterEntity> getCharactersByFilters (CharacterFiltersDTO filtersDTO) {

        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            //By name
            if (StringUtils.hasLength(filtersDTO.getName())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("name")),
                                "%" + filtersDTO.getName().toLowerCase() + "%"
                        )
                );
            }

            //By age
            if (filtersDTO.getAge() != null) {
                predicates.add(
                        criteriaBuilder.equal(root.get("age"), filtersDTO.getAge())
                );
            }

            //By weight
            if (filtersDTO.getWeight() != null) {
                predicates.add(
                        criteriaBuilder.equal(root.get("age"), filtersDTO.getWeight())
                );
            }

            //By movies
            if(!CollectionUtils.isEmpty(filtersDTO.getMovies())) {
                Join<CharacterEntity, MovieEntity> join = root.join("movies", JoinType.INNER);
                Expression<String> moviesId = join.get("id");
                predicates.add(moviesId.in(filtersDTO.getMovies()));
            }

            query.distinct(true);
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
