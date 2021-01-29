package Project;

public class Dni {
    public double temp;
    public double tempInC;
    public int humidity;
    public int pressure;
    public int clouds;
    public double wind;
    public int dzien;
    public String opis;
    public String data;
    public double rain = 0;
    public double snow = 0;

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getWind() {
        return wind;
    }

    public void setWind(double wind) {
        this.wind = wind;
    }

    public Dni() {
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        tempInC = temp-273;
        tempInC = tempInC*100;
        tempInC = Math.round(tempInC);
        tempInC = tempInC/100;
        this.temp = tempInC;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public int getDzien() {
        return dzien;
    }

    public void setDzien(int dzien) {
        this.dzien = dzien;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getRain() {
        return rain;
    }

    public void setRain(double rain) {
        this.rain = rain;
    }

    public double getSnow() {
        return snow;
    }

    public void setSnow(double snow) {
        this.snow = snow;
    }

    @Override
    public String toString() {
        return "DATA: " + data + ": " +
                "Temperatura= " + temp +" C"+
                ", deszcz= " + rain + ", śnieg= " + snow +
                ", wilgotność= " + humidity +
                ", ciśnienie= " + pressure + "hPa"+
                ", chmury= " + clouds +
                ", wiatr= " + wind +"km/h."+", Opis= "+opis + "\n";
    }
}
