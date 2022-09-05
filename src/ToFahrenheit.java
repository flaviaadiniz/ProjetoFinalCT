public class ToFahrenheit {

    public double toFahrenheitTransform(UnityTemp type, double temp) {
        if (type == UnityTemp.CELSIUS) {
            return (temp * 1.8) + 32;
        } else if(type == UnityTemp.KELVIN) {
            return ((temp - 273.15) * 1.8) + 32;
        } else {
            return temp;
        }
    }
}