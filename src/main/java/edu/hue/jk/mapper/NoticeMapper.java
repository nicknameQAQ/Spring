package edu.hue.jk.mapper;

import edu.hue.jk.model.Notice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface NoticeMapper {

    @Select("select n_id as nId, title, details, n_time as nTime from notice")
    List<Notice> findAll();

    @Select("select n_id as nId, title, details, n_time as nTime " +
            "from notice where n_id = #{nId}")
    Notice findById(@Param("nId") int nId);

    @Insert("insert into notice (title, details, n_time) " +
            "values (#{title}, #{details}, #{nTime})")
    int insert(Notice notice);

    @Update("update notice set title = #{title}, details = #{details}, " +
            "n_time = #{nTime} where n_id = #{nId}")
    int update(Notice notice);

    @Delete("delete from notice where n_id = #{nId}")
    int delete(@Param("nId") int nId);
}