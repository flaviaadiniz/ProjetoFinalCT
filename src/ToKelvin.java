public class ToKelvin {

    public double toKelvinTransform(UnityTemp type, double temp) {
        if (type == UnityTemp.CELSIUS) {
            return temp + 273.15;
        } else if(type == UnityTemp.FAHRENHEIT) {
            return ((temp - 32) / 1.8) + 273.15;
        } else {
            return temp;
        }
    }

}