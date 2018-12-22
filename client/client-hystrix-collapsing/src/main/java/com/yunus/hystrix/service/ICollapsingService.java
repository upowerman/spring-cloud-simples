package com.yunus.hystrix.service;

import java.util.concurrent.Future;

import com.yunus.provider.model.Animal;

/**
 * @author lanxum
 */
public interface ICollapsingService {
    Future<Animal> collapsing(Integer id);

    Animal collapsingSyn(Integer id);

    Future<Animal> collapsingGlobal(Integer id);

}
