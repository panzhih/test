package com.testweb.otherTest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImportTest {
    public static void main(String[] args){
        File file = new File(new File("").getAbsolutePath()+"/testXlsx.xlsx");
        new ImportTest().createOpenSchedules(file);
    }


    private void createOpenSchedules(File file){
        try {
            FileInputStream inputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            Iterator<XSSFSheet> iterator = workbook.iterator();
            while(iterator.hasNext()){
                XSSFSheet xssfSheet = iterator.next();
                //检测广告位（标题项为广告位名称）
                String title = getTitle(xssfSheet);
                int startRow = xssfSheet.getFirstRowNum()+3;
                int endRow = xssfSheet.getLastRowNum();
                int coloumNum = xssfSheet.getRow(0).getPhysicalNumberOfCells();//获取最大列数
                LinkedHashMap<String,Object> resultList = new LinkedHashMap<>();
                for(int i=1;i<coloumNum-1;i++){
                    DecimalFormat decimalFormat = new DecimalFormat("0");
                    //转化date类型数据
                    Cell cell = xssfSheet.getRow(1).getCell(i);
                    String cellValue = "";
                    if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
                        short format = cell.getCellStyle().getDataFormat();
                        if(format == 14 || format == 31 || format == 57 || format == 58){
                            Date date = cell.getDateCellValue();
                            cellValue = DateFormatUtils.format(date, "yyyy-MM-dd");
                        }else {
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            cellValue = String.valueOf(cell.getStringCellValue());
                        }
                    }
                    Cell cell2 = xssfSheet.getRow(2).getCell(i);
                    String week = "";
                    if(cell2.getCellType() == Cell.CELL_TYPE_NUMERIC){
                        week = decimalFormat.format(cell2.getNumericCellValue());
                    }else{
                        week = cell2.getStringCellValue();
                    }
                    for(int j = startRow ; j < endRow-startRow ; j++){
                        XSSFRow row = xssfSheet.getRow(j);
                        Cell timeType = row.getCell(0);
                        Cell nameCell = row.getCell(i);
                        if(timeType != null && nameCell != null){

                            String time = "";
                            String name = "";
                            if(timeType.getCellType() == Cell.CELL_TYPE_NUMERIC){
                                System.out.println("排期时间段不能为数值类型");
                            }else{
                                time = timeType.getStringCellValue();
                            }
                            if(nameCell.getCellType() == Cell.CELL_TYPE_NUMERIC){
                                name = replace(decimalFormat.format(nameCell.getNumericCellValue()));
                            }else{
                                name = replace(nameCell.getStringCellValue());
                            }
                            if(StringUtils.isNotBlank(time) && StringUtils.isNotEmpty(name)){
                                if(resultList.get(name) == null){
                                    LinkedHashMap<String,Object> timeList = new LinkedHashMap<>();
                                    LinkedHashMap<String,Object> con = new LinkedHashMap<>();
                                    LinkedHashMap<String,String> timeMap = new LinkedHashMap<>();
                                    con.put("date",cellValue);
                                    con.put("week",week);
                                    con.put("title",title);
                                    timeMap.put(time,name);
                                    con.put("times",timeMap);
                                    timeList.put(cellValue,con);
                                    resultList.put(name,timeList);
                                }else{
                                    if(((LinkedHashMap<String, Object>) resultList.get(name)).get(cellValue) == null){
                                        LinkedHashMap<String,Object> con = new LinkedHashMap<>();
                                        LinkedHashMap<String,String> timeMap = new LinkedHashMap<>();
                                        con.put("date",cellValue);
                                        con.put("week",week);
                                        con.put("title",title);
                                        timeMap.put(time,name);
                                        con.put("times",timeMap);
                                        ((LinkedHashMap<String, Object>) resultList.get(name)).put(cellValue,con);
                                    }else{
                                        ((LinkedHashMap<String,String>)((LinkedHashMap<String,Object>)((LinkedHashMap<String, Object>) resultList.get(name)).get(cellValue)).get("times")).put(time,name);
                                    }
                                }
                            }
                        }
                    }
                }
                if(resultList.size() > 0){
                    //处理合并时间
                    checkTimes(resultList);

                    //检测素材
                    /*for(Map.Entry<String,Object> entry : resultList.entrySet()){
                        String materialName = entry.getKey();
                        System.out.println("name = "+materialName);
                        R<List<MaterialVO>> materialVos = materialClient.getMaterialByName(materialName.trim());
                        List<MaterialVO> materialVO = materialVos.getData();
                        if(materialVO == null || materialVO.size() == 0){
                            return R.fail("素材 "+materialName+" 不存在");
                        }
                    }*/
                    //检测排期冲突
                    /*if (force == 0) {
                        for(Map.Entry<String,Object> entry : resultList.entrySet()){
                            LinkedHashMap<String,Object> linkedHashMap = (LinkedHashMap<String,Object>)entry.getValue();
                            List<TimeBlockWithBLOBs> timeBlocks = new ArrayList<>();//排期时间
                            List<String> scheduleDate = new ArrayList<>();
                            String materialName = entry.getKey();
                            R<List<MaterialVO>> materialVos = materialClient.getMaterialByName(materialName);
                            List<MaterialVO> materialVO = materialVos.getData();
                            this.createTimes(linkedHashMap,materialVO,timeBlocks,scheduleDate);
                            if(type == 4){
                                type = 3;
                            }
                            ScheduleWithBLOBs schedule = createSchedule(scheduleDate,"",materialName,linkedHashMap,title,orderId,creator,priorityType,leval,force,type);

                            //检测排期冲突
                            R rdata = scheduleService.checkTimeConflict(null,schedule,timeBlocks,null);
                            if (403 == rdata.getCode()) {
                                return rdata;
                            }
                        }
                    }*/
                    //检测第一张开机排期是否合理创建
                    /*if(type == 0){
                        for(Map.Entry<String,Object> entry : resultList.entrySet()){
                            LinkedHashMap<String,Object> linkedHashMap = (LinkedHashMap<String,Object>)entry.getValue();
                            List<TimeBlockWithBLOBs> timeBlocks = new ArrayList<>();//排期时间
                            List<String> scheduleDate = new ArrayList<>();
                            String materialName = entry.getKey();
                            R<List<MaterialVO>> materialVos = materialClient.getMaterialByName(materialName);
                            List<MaterialVO> materialVO = materialVos.getData();
                            this.createTimes(linkedHashMap,materialVO,timeBlocks,scheduleDate);
                            ScheduleWithBLOBs schedule = createSchedule(scheduleDate,"",materialName,linkedHashMap,title,orderId,creator,priorityType,leval,force,type);

                            //开机第一张排期检测
                            R result = scheduleService.checkStartingUpData(null,schedule);
                            if(400 == result.getCode()){
                                return result;
                            }
                        }
                    }*/


                    //保存排期相关内容
                    /*for(Map.Entry<String,Object> entry : resultList.entrySet()){
                        List<TimeBlockWithBLOBs> timeBlocks = new ArrayList<>();//排期时间
                        List<String> scheduleDate = new ArrayList<>();
                        LinkedHashMap<String,Object> linkedHashMap = (LinkedHashMap<String,Object>)entry.getValue();
                        String materialName = entry.getKey();
                        R<List<MaterialVO>> materialVos = materialClient.getMaterialByName(materialName);
                        List<MaterialVO> materialVO = materialVos.getData();
                        this.createTimes(linkedHashMap,materialVO,timeBlocks,scheduleDate);
                        String name = "开机第一张广告排期("+materialName+")_"+System.currentTimeMillis();
                        if(type == 4){
                            name = "开机第二张广告排期("+materialName+")_"+System.currentTimeMillis();
                            type = 3;
                        }
                        //保存排期
                        ScheduleWithBLOBs schedule = createSchedule(scheduleDate,name,materialName,linkedHashMap,title,orderId,creator,priorityType,leval,force,type);
                        scheduleService.save(schedule);
                        //获取排期
                        QueryWrapper<ScheduleWithBLOBs> queryWrapper = new QueryWrapper();
                        queryWrapper.eq("name",name);
                        List<ScheduleWithBLOBs> scheduleWithBLOBs = scheduleService.list(queryWrapper);
                        if(scheduleWithBLOBs != null && scheduleWithBLOBs.size() > 0){
                            schedule = scheduleWithBLOBs.get(0);
                        }
                        System.out.println("保存排期=="+schedule.getName());
                        //保存排期审核
                        scheduleSubmitAudio(schedule);
                        System.out.println("保存审核==");
                        //保存时间表
                        for(TimeBlockWithBLOBs timeBlock : timeBlocks){
                            Map<Object,Object> scheduleMap = new HashMap<>();
                            timeBlock.setScheduleId(schedule.getId());
                            timeBlockService.saveTimeBlockContent(scheduleMap,timeBlock);
                        }
                        System.out.println("保存排期时间==");
                        //保存排期策略
                        ScheduleTactics scheduleTactics = new ScheduleTactics();
                        scheduleTactics.setScheduleId(schedule.getId());
                        tacticsService.saveTacticsContent(new HashMap<>(), scheduleTactics);
                        System.out.println("保存排期策略==");
                    }*/
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件没有找到");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("io异常");
        }
        System.out.println("ok");
    }

    private static String getTitle(XSSFSheet xssfSheet){
        DecimalFormat decimalFormat = new DecimalFormat("0");
        Cell cell = xssfSheet.getRow(0).getCell(0);
        String title = "";
        if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
            title = decimalFormat.format(cell.getNumericCellValue());
        }else{
            title = cell.getStringCellValue();
        }
        return title;
    }

    public static String replace(String param) {
        String destination = "";
        if (param!=null) {
            Pattern p = Pattern.compile("\t|\r|\n");
            Matcher m = p.matcher(param);
            destination = m.replaceAll("").trim();
        }
        return destination;
    }

    //合并时间段
    private void checkTimes(LinkedHashMap<String, Object> resultList) {
        for(Map.Entry<String,Object> entry : resultList.entrySet()){
            LinkedHashMap<String,Object> linkedHashMap = (LinkedHashMap<String,Object>)entry.getValue();
            for(Map.Entry<String,Object> entry1 : linkedHashMap.entrySet()){
                LinkedHashMap<String,Object> entryListMap = (LinkedHashMap<String,Object>)entry1.getValue();
                LinkedHashMap<String,String> times = (LinkedHashMap<String,String>)entryListMap.get("times");
                LinkedHashMap<String,String> cloneTimes = (LinkedHashMap<String,String>)times.clone();
                for(Map.Entry<String,String> tMap : cloneTimes.entrySet()){
                    String time = tMap.getKey();
                    filterTimes(time,times);
                }

            }
        }
    }

    //递归修改时间集合
    private void filterTimes(String time, LinkedHashMap<String, String> stringStringLinkedHashMap) {
        String[] timeStr = time.split("-");
        String endTime = "";
        for (String itTime : stringStringLinkedHashMap.keySet()){
            //对比是否包含
            if(itTime.startsWith(timeStr[1])){
                endTime = itTime;
            }
        }
        if(org.apache.commons.lang.StringUtils.isNotBlank(endTime)){
            String eTime = endTime.split("-")[1];
            String pjTime = timeStr[0]+"-"+eTime;
            stringStringLinkedHashMap.remove(endTime);
            stringStringLinkedHashMap.put(pjTime,stringStringLinkedHashMap.get(time));
            stringStringLinkedHashMap.remove(time);
            filterTimes(pjTime, stringStringLinkedHashMap);
        }
    }
}
