package com.altersoftware.hotel.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;

/**
 * excel解析工具类
 * 
 * @author 15272
 */
public class ExcelUtil {

    public static Object getCellValue(Cell cell) {
        Object value = null;
        DecimalFormat dfs = new DecimalFormat("0"); // 格式化字符类型的数字
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 日期格式化
        DecimalFormat dfn = new DecimalFormat("0.00"); // 格式化数字
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                value = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                    value = dfs.format(cell.getNumericCellValue());
                } else if ("m/d/yy".equals(cell.getCellStyle().getDataFormatString())) {
                    value = sdf.format(cell.getDateCellValue());
                } else {
                    value = dfn.format(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
            default:
                break;
        }
        return value;
    }
}
