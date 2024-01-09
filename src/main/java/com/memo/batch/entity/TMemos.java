package com.memo.batch.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.opencsv.bean.CsvBindByName;

import lombok.Data;

@Data
public class TMemos {
	@JsonFormat
	@CsvBindByName(column = "id", required = true)
	private int id;
	@JsonFormat
	@CsvBindByName(column = "title", required = true)
	private String title;
	@JsonFormat
	@CsvBindByName(column = "detail", required = true)
	private String detail;
	@JsonFormat
	@CsvBindByName(column = "userId", required = true)
	private int userId;
	@JsonFormat
	@CsvBindByName(column = "isDeleted", required = true)
	private boolean isDeleted;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Tokyo")
	private LocalDateTime createdAt;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Tokyo")
	private LocalDateTime updatedAt;
}
