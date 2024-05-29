package com.example.demo.common.exception.data;

import java.util.List;

public class ListDataFactory {
    public static <T> ListData<T> createListData(List<T> dataList) {
        ListData<T> listData = new ListData<>();
        listData.setList(dataList);
        return listData;
    }
}
