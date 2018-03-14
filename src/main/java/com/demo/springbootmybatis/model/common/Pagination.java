package com.demo.springbootmybatis.model.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class Pagination<T> implements java.io.Serializable {

	@ApiModelProperty("记录总数")
	private Long total = 0L;

	@ApiModelProperty("查询结果")
	private List<T> results = Collections.emptyList();

	@ApiModelProperty("当前页码")
	private int pageIndex = 1;

	@ApiModelProperty("每页记录数")
	private int pageSize = 10;

}