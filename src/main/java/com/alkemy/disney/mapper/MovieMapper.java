package com.alkemy.disney.mapper;
import com.alkemy.disney.DTO.CharacterBasicDTO;
import com.alkemy.disney.DTO.CharacterDTO;
import com.alkemy.disney.DTO.MovieBasicDTO;
import com.alkemy.disney.DTO.MovieDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.MovieEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Component
public class MovieMapper {

    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private CharacterMapper characterMapper;
    @Autowired
    private GenderMapper genderMapper;


    public MovieEntity movieDTO2Entity(MovieDTO movieDTO) {  //2
        MovieEntity entity = new MovieEntity();
        entity.setImage(movieDTO.getImage());
        entity.setTitle(movieDTO.getTitle());
       // entity.setCreationDate(this.string2LocalDate(movieDTO.getCreationDate()));
        entity.setRating(movieDTO.getRating());
        entity.setGender(genderMapper.genderDTO2Entity(movieDTO.getGender()));
        List<CharacterEntity> characters = this.characterMapper.characterDTOList2EntityList(movieDTO.getCharacters()); //3
        entity.setCharacters(characters);
        return entity;
    }


    private LocalDate string2LocalDate(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(stringDate, formatter);
    }

    public MovieDTO movieEntity2DTO(MovieEntity entity, boolean loadCharacters) {  //11
        MovieDTO dto = new MovieDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setTitle(entity.getTitle());
    //    dto.setCreationDate(entity.getCreationDate().toString());
        dto.setRating(entity.getRating());
        dto.setGender(genderMapper.genderEntity2DTO(entity.getGender()));
        if (loadCharacters) {
            List<CharacterDTO> characters = this.characterMapper.characterEntityList2DTOList(entity.getCharacters(), false);
            dto.setCharacters(characters);
        }
        return dto;
    }

    public MovieBasicDTO movieEntity2DTOBasic (MovieEntity entity){
        MovieBasicDTO dto = new MovieBasicDTO();
        dto.setImage(entity.getImage());
        dto.setTitle(entity.getTitle());
       // dto.setCreationDate(entity.getCreationDate().toString());
        return dto;
    }

    public List<MovieDTO> movieEntityList2DTOList(List<MovieEntity> entities, boolean loadCharacters) {  //15
        List<MovieDTO> dtos = new ArrayList<>();
        for (MovieEntity entity : entities) {
            dtos.add(movieEntity2DTO(entity, loadCharacters));
        }
        return dtos;
    }

    //Convert Movie List Entity to List DTO Basic
    public List<MovieBasicDTO> movieEntityList2DTOBasicList (List<MovieEntity> entities){
        List<MovieBasicDTO> dtos = new ArrayList<>();
        for ( MovieEntity entity : entities ){
            dtos.add(this.movieEntity2DTOBasic(entity));
        }
        return dtos;
    }

    public MovieEntity updateEntity(MovieEntity entity, MovieDTO dto){
        entity.setTitle(dto.getTitle());
        entity.setImage(dto.getImage());
        return entity;
    }

}






/*


    public MovieEntity movieBasicDTO2Entity (MovieDTO dto){
        return modelMapper.map(dto, MovieEntity.class);
    }

    public List<MovieBasicDTO> movieEntityList2BasicDTOList(List<MovieEntity> entityList) {
        List<MovieBasicDTO> basicDTOList = new ArrayList<>();
        for (MovieEntity entity : entityList) {
            basicDTOList.add(movieEntity2BasicDTO(entity));
        }
        return basicDTOList;
    }

    public MovieBasicDTO movieEntity2BasicDTO (MovieEntity entity){
        return modelMapper.map(entity, MovieBasicDTO.class);
    }
}

*/

