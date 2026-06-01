package onlineMedicineshoppingSystem.demo.entity;

import lombok.Data;

@Data
public class Medicine {
    private long id;
    private String name;
    private double price;
    private String companyName;
    private String category;

}
