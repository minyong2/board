package com.dw.board.service;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dw.board.mapper.BoardMapper;

@Service
public class ExcelService {
	@Autowired
	private BoardMapper boardMapper;

	public Workbook makeExcelForm() throws Exception {

		Workbook workbook = new HSSFWorkbook(); // 엑셀 생성
		Sheet sheet = workbook.createSheet("게시판 자료");
		Row row = null; // 엑셀 행
		Cell cell = null; // 엑셀 열
		int rowNumber = 0; // 행 번호
		
		CellStyle headStyle = makeExcelHeadStyle(workbook);
		CellStyle bodyStyle = makeExcelBodyStyle(workbook);

		row = sheet.createRow(rowNumber++); // 첫번째 행
		cell = row.createCell(0); // 첫번째 열
		cell.setCellStyle(headStyle);
		cell.setCellValue("게시판번호");

		cell = row.createCell(1); // 두 번째 열
		cell.setCellStyle(headStyle);
		cell.setCellValue("작성자");

		cell = row.createCell(2); // 세 번째 열
		cell.setCellStyle(headStyle);
		cell.setCellValue("제목");

		cell = row.createCell(3); // 네 번째 열
		cell.setCellStyle(headStyle);
		cell.setCellValue("수정 날짜");

		cell = row.createCell(4); // 첫번째 열
		cell.setCellStyle(headStyle);
		cell.setCellValue("작성 날짜");

		cell = row.createCell(5); // 다섯 번째 열
		cell.setCellStyle(headStyle);
		cell.setCellValue("조회 수");

		// mapper 호출
		List<Map<String, Object>> list = boardMapper.selectAllBoardList();

		for (Map<String, Object> data : list) {
			row = sheet.createRow(rowNumber++); // 행을 계속 추가해준다 for문 조건식이 만족할 때 까지
			cell = row.createCell(0);// 게시판 번호
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.get("boardId").toString());

			cell = row.createCell(1);// 작성자
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.get("studentsName").toString());

			cell = row.createCell(2);// 제목
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.get("title").toString());

			cell = row.createCell(3);// 수정날짜
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.get("updateAt").toString());

			cell = row.createCell(4);// 작성 날짜
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.get("createAt").toString());

			cell = row.createCell(5);// 조회 수
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.get("cnt").toString());
		}

		return workbook;
	}

	// 엑셀 head style 수정
	public CellStyle makeExcelHeadStyle(Workbook workbook) {
		CellStyle cellStyle = null;
		cellStyle = workbook.createCellStyle();
		// 가는 경계선 생성
		cellStyle.setBorderTop(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setBorderRight(BorderStyle.THIN);
		cellStyle.setBorderBottom(BorderStyle.THIN);
		// 배경색 생성
		cellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.YELLOW.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		// 가운데 정렬
		cellStyle.setAlignment(HorizontalAlignment.CENTER);

		return cellStyle;
	}

	public CellStyle makeExcelBodyStyle(Workbook workbook) {
		CellStyle cellStyle = null;
		cellStyle = workbook.createCellStyle();
		// 가는 경계선 생성
		cellStyle.setBorderTop(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setBorderRight(BorderStyle.THIN);
		cellStyle.setBorderBottom(BorderStyle.THIN);

		return cellStyle;
	}

}
