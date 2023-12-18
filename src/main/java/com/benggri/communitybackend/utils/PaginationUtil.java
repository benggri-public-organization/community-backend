package com.benggri.communitybackend.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.benggri.communitybackend.model.vo.common.PaginationVo;

public class PaginationUtil {

    public static PaginationVo calcPage(Long totalCount, Integer pageNo, Integer pagePercount) {
        return calcPage(totalCount, pageNo, pagePercount, 5);
    }

    public static PaginationVo calcPage(Long totalCount, Integer pageNo, Integer pagePercount, Integer maxPage) {
        if (totalCount <= 0 || maxPage <= 0)
            return PaginationVo.builder()
                    .totalCount(totalCount)
                    .pageNo(1)
                    .pagePerCount(pagePercount)
                    .totalPage(0)
                    .startPage(0)
                    .endPage(0)
                    .pages(Arrays.asList())
                    .build();

        int totalPage = (int) Math.ceil(totalCount * 1.0 / pagePercount);
        if (pageNo < 1) {
            pageNo = 1;
        } else if (pageNo > totalPage) {
            pageNo = totalPage;
        }

        int startPage = 1;
        int endPage = maxPage;
        if (totalPage <= maxPage) {
            startPage = 1;
            endPage = totalPage;
        } else {
            int maxPageBeforeCurrentPage = (int) Math.floor(maxPage * 1.0 / 2);
            int maxPagesAfterCurrentPage = (int) Math.ceil(maxPage * 1.0 / 2) - 1;
            if (pageNo <= maxPageBeforeCurrentPage) {
                startPage = 1;
                endPage = maxPage;
            } else if (pageNo + maxPagesAfterCurrentPage >= totalPage) {
                startPage = totalPage - maxPage + 1;
                endPage = totalPage;
            } else {
                startPage = pageNo - maxPageBeforeCurrentPage;
                endPage = pageNo + maxPagesAfterCurrentPage;
            }
        }

        List<Integer> pages = new ArrayList<Integer>();
        for (int i = startPage; i <= endPage; i++) {
            pages.add(i);
        }
        return PaginationVo.builder()
                .totalCount(totalCount)
                .pageNo(pageNo)
                .pagePerCount(pagePercount)
                .totalPage(totalPage)
                .startPage(startPage)
                .endPage(endPage)
                .pages(pages)
                .build();
    }

}
