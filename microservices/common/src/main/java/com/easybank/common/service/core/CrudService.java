package com.easybank.common.service.core;

public interface CrudService<E, ID> {
    E findById(ID id);
    E save(E e);
    E delete(ID id);
}
