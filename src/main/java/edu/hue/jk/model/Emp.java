package edu.hue.jk.model;

import java.sql.Date;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "emp")
public class Emp {
    private Integer empno;
    private String ename;
    private Date hiredate;
    private Double sal;
}