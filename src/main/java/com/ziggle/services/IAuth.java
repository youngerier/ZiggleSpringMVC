package com.ziggle.services;

import com.ziggle.entity.Auth;

import java.util.List;

public interface IAuth {

    public void add(Auth auth);

    public void update(Auth auth);

    public void delete(Auth auth);

    public Auth load(Auth auth);

    public List<Auth> list(Auth auth);

    public Auth loadBUsername(String username);
}
