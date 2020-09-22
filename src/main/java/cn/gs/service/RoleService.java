package cn.gs.service;

import cn.gs.model.Role;

import java.util.List;
import cn.gs.mapper.RoleMapper;
import cn.gs.model.Role;
import cn.gs.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import cn.gs.mapper.RoleMapper;
import cn.gs.model.Role;
import cn.gs.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import cn.gs.mapper.RoleMapper;
import cn.gs.model.Role;
import cn.gs.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
public interface RoleService {
    public List<Role> queryListById(int id);
}
