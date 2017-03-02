package be.vdab.repositories;


import be.vdab.entities.Brouwer;
import be.vdab.valueobjects.Adres;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Maarten Westelinck on 6/02/2017 for brouwers.
 */
@Repository
@ReadOnlyTransactionalService
public class JdbcBrouwerRepository implements BrouwerRepository{

    private static final String BEGIN_SQL = "select id, naam, postcode, gemeente, omzet, straat, huisnr from brouwers ";
    private static final String SQL_FIND_ALL = BEGIN_SQL + "order by naam";
    private static final String BEGINNAAM_SQL = BEGIN_SQL + "where naam like ?";

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;
    private final RowMapper<Brouwer> rowMapper = ((resultSet, i) ->
       new Brouwer(
               resultSet.getLong("id"),
               resultSet.getString("naam"),
               resultSet.getInt("omzet"),
               new Adres(
                       resultSet.getString("straat"),
                       resultSet.getString("huisnr"),
                       resultSet.getInt("postcode"),
                       resultSet.getString("gemeente")

               )
       )
    );

    public JdbcBrouwerRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("brouwers");
        simpleJdbcInsert.usingGeneratedKeyColumns("id");
    }

    @Override
    @ModifyingTransactionalServiceMethod
    public void create(Brouwer brouwer) {
        Map<String, Object> kolomWaarden = new HashMap<>();
        kolomWaarden.put("naam", brouwer.getNaam());
        kolomWaarden.put("omzet", brouwer.getOmzet());
        kolomWaarden.put("postcode", brouwer.getAdres().getPostcode());
        kolomWaarden.put("gemeente", brouwer.getAdres().getGemeente());
        kolomWaarden.put("straat", brouwer.getAdres().getStraat());
        kolomWaarden.put("huisnr", brouwer.getAdres().getHuisNr());
        simpleJdbcInsert.executeAndReturnKey(kolomWaarden);
    }

    @Override
    public List<Brouwer> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, rowMapper);
    }

    @Override
    public List<Brouwer> findByNaam(String beginNaam) {
        return jdbcTemplate.query(BEGINNAAM_SQL, rowMapper, beginNaam + "%");
    }

}
