package org.spring.springboot.service.impl;

import org.spring.springboot.dao.CityDao;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    public List<City> findAllCity(){
        return cityDao.findAllCity();
    }

    public City findCityById(Long id) {
        return cityDao.findById(id);
    }

    @Override
    public String saveCity(City city) {
    	if (cityDao.findById(city.getId()) != null) {
    		return "您要保存的对象已经存在 ！";
    	} else {
    		if (cityDao.saveCity(city) == 1) {
    			return "保存成功 ！";
    		} else {
    			return "保存失败 ！！";
    		}
    	}
    }

    @Override
    public String updateCity(City city) {
    	if (cityDao.findById(city.getId()) == null) {
    		return "您要更新的对象不存在 ！";
    	} else {
    		if (cityDao.updateCity(city) == 1) {
    			return "更新成功 ！";
    		} else {
    			return "更新失败 ！！";
    		}
    	}
    }

    @Override
    public String deleteCity(Long id) {
    	if (cityDao.findById(id) == null) {
    		return "您要删除的对象不存在 ！";
    	} else {
    		if (cityDao.deleteCity(id) == 1) {
    			return "删除成功 ！";
    		} else {
    			return "删除失败 ！！";
    		}
    	}
    }

}
