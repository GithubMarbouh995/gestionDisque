package com.example.demoe_2jee;

import java.util.List;

public interface  BrandDao {
//    public void saveBrand(Brand brand);
    public void updateBrand(Brand brand,int id);
    public void add_Brand(Brand brand);

    public void deleteBrend(int id);
    List<Brand> getAllBrand();
}
