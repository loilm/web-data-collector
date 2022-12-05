package pages;

import commons.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.*;

public class VietlottPage {
    private WebDriver driver;
    private CommonPage commonPage;

    private class TextFreq {
        String text;
        int freq;

        public TextFreq(String text, int freq) {
            this.text = text;
            this.freq = freq;
        }

        @Override
        public String toString() {
            return "Cap so vi tri (06) la: " + text + " lap lai " + freq + " lan";
        }
    }

    public VietlottPage(WebDriver driver) {
        this.driver = driver;
        commonPage = new CommonPage(driver);
    }

    public String getDataOfRow(int i) {
        By day = By.xpath("//tbody/tr[" + i + "]/td[1]");
        By id = By.xpath("//tbody/tr[" + i + "]/td[2]/a");
        By item1 = By.xpath("//tbody/tr[" + i + "]/td[3]/div/span[1]");
        By item2 = By.xpath("//tbody/tr[" + i + "]/td[3]/div/span[2]");
        By item3 = By.xpath("//tbody/tr[" + i + "]/td[3]/div/span[3]");
        By item4 = By.xpath("//tbody/tr[" + i + "]/td[3]/div/span[4]");
        By item5 = By.xpath("//tbody/tr[" + i + "]/td[3]/div/span[5]");
        By item6 = By.xpath("//tbody/tr[" + i + "]/td[3]/div/span[6]");

        String dayTxt = commonPage.getText(day);
        String idTxt = commonPage.getText(id);
        String item1Txt = commonPage.getText(item1);
        String item2Txt = commonPage.getText(item2);
        String item3Txt = commonPage.getText(item3);
        String item4Txt = commonPage.getText(item4);
        String item5Txt = commonPage.getText(item5);
        String item6Txt = commonPage.getText(item6);

        String numString = item1Txt + item2Txt + item3Txt + item4Txt + item5Txt + item6Txt;
        String rowData = dayTxt + " | " + idTxt + " | " + numString;
        return rowData;
    }

    public List<String> getDataByPage(int pageNum, int itemOnPage) {
        int count = 0;
        List<String> data = new ArrayList<>();
        for (int i = 1; i <= pageNum; i++) {
            if (count >= pageNum) {
                break;
            }
            for (int j = 1; j <= itemOnPage; j++) {
                data.add(getDataOfRow(j));
            }
            commonPage.clickElement(By.xpath("//ul[@class='pagination']/li[7]/a"));
            count += 1;
        }
        return data;
    }

    public void getListLastTwoDigitsWithFrequent(List list) {
        /*get last 2 digits*/
        List<String> listStr = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int rowLength = list.get(i).toString().length();
            listStr.add(list.get(i).toString().substring(rowLength - 2));
        }
        Map<String, TextFreq> map = new HashMap<>();
        for (String text : listStr) {
            TextFreq textFreq = map.get(text);
            if (textFreq == null)
                map.put(text, new TextFreq(text, 1));
            else
                textFreq.freq++;
        }

        List<TextFreq> listForSort = new ArrayList<>(map.values());
        Collections.sort(listForSort, (o1, o2) -> Integer.compare(o2.freq, o1.freq));
        getNItemOfList(listForSort, 10);
    }

    /*get N Item, Ex: get 10 items of list*/
    public void getNItemOfList(List list, int n) {
        System.out.println("Danh sach cap so top " + n + ":");
        for (int i = 0; i < list.size(); i++) {
            if (i >= n) {
                break;
            }
            System.out.println(list.get(i).toString());
        }
    }
}
