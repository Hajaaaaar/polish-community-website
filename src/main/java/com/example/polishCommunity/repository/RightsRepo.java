package com.example.polishCommunity.repository;

import com.example.polishCommunity.model.Rights;
import com.example.polishCommunity.model.RightsFAQs;
import com.example.polishCommunity.model.SubRights;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RightsRepo {

    private JdbcTemplate jdbcTemplate;
    private RowMapper<Rights> rightsMapper;
    private RowMapper<SubRights> subRightsMapper;
    private RowMapper<RightsFAQs> rightsFAQsMapper;

    public RightsRepo(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
        setRightsMapper();
        setSubRightsMapper();
        setRightsFAQsMapper();
    }

    public void setRightsMapper(){
        rightsMapper = (rs,i) -> new Rights(
                rs.getInt("title_id"),
                rs.getString("title"),
                rs.getString("description")
        );
    }

    public void setSubRightsMapper() {
        subRightsMapper = (rs, i) -> new SubRights(
                rs.getInt("sub_title_id"),
                rs.getString("sub_title"),
                rs.getString("description"),
                rs.getInt("title_id")
        );
    }
    public void setRightsFAQsMapper() {
        rightsFAQsMapper = (rs, i) -> new RightsFAQs(
                rs.getInt("que_id"),
                rs.getString("que"),
                rs.getString("answer"),
                rs.getInt("title_id")
        );
    }

    public Rights getRightsById(int id){
        String sql = "select * from rights where title_id = ?";
        return jdbcTemplate.queryForObject(sql,rightsMapper,id);
    }

    public List<SubRights> getSubRightsByRightsId(int id){
        String sql = "select * from sub_rights where title_id =?";
        return jdbcTemplate.query(sql, subRightsMapper, id);
    }

    public void addSubRight(SubRights subRights) {
        String sql = "INSERT INTO sub_rights (sub_title, description, title_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, subRights.getSubTitle(),
                subRights.getDescription(),subRights.getTitleId());
    }

    public List<RightsFAQs> getRightsFAQsByRightsId(int id){
        String sql = "select * from rights_FAQs where title_id =?";
        return jdbcTemplate.query(sql, rightsFAQsMapper, id);
        }
}
