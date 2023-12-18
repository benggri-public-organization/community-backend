package com.benggri.communitybackend.utils;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import org.springframework.util.ObjectUtils;

import com.benggri.communitybackend.model.vo.common.OrderByVo;
import com.benggri.communitybackend.model.vo.common.PaginationVo;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.Expressions;

public class QueryUtil {
    public static Order getDirection(String direction) {
        Order result = ("asc".equals(direction) ? Order.ASC : Order.DESC);
        return result;
    }

    public static Path<Object> getPath(EntityPathBase entityPathBase, String column) {
        Path<Object> fieldPath = Expressions.path(Object.class, entityPathBase, column);
        return fieldPath;
    }

    public static OrderSpecifier getOrderSpecifier(EntityPathBase entityPathBase, String column, String direction) {
        Order d = getDirection(direction);
        Path<Object> p = getPath(entityPathBase, column);
        return new OrderSpecifier(d, p);
    }

    public static OrderSpecifier[] getOrderByList(Map<String, EntityPathBase> orderByMap, PaginationVo reqVo) {
        List<OrderSpecifier> result = new ArrayList<>();
        for (OrderByVo vo : reqVo.getOrderByVos()) {
            if (!ObjectUtils.isEmpty(orderByMap.get(vo.getOrderByColumn()))) {
                result.add(getOrderSpecifier(orderByMap.get(vo.getOrderByColumn()), vo.getOrderByColumn(),
                        vo.getOrderByDirection()));
            }
        }
        return result.toArray(new OrderSpecifier[result.size()]);
    }

}
