package co.develhope.meteoapp;

public class HomeScreen {
    String todayCard;
    String minTemp;
    String maxTemp;
    String dateCard;
    String minText;
    String maxText;
    String rainfallPercent;
    String windKmh;
    String rainfallText;
    String windText;
    int image;


    public HomeScreen(String todayCard, String minTemp, String maxTemp, String dateCard,
                      String minText, String maxText, String rainfallPercent, String windKmh,
                      String rainfallText, String windText, int image) {
        this.todayCard = todayCard;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.dateCard = dateCard;
        this.minText = minText;
        this.maxText = maxText;
        this.rainfallPercent = rainfallPercent;
        this.windKmh = windKmh;
        this.rainfallText = rainfallText;
        this.windText = windText;
        this.image = image;
    }

    public String getTodayCard() {
        return todayCard;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public String getDateCard() {
        return dateCard;
    }

    public String getMinText() {
        return minText;
    }

    public String getMaxText() {
        return maxText;
    }

    public String getRainfallPercent() {
        return rainfallPercent;
    }

    public String getWindKmh() {
        return windKmh;
    }

    public String getRainfallText() {
        return rainfallText;
    }

    public String getWindText() {
        return windText;
    }

    public int getImage() {
        return image;
    }
}
