package main.java.sensorval;

import java.util.List;

public class SensorValidator 
{
	static float maxSOCDelta = 0.1f;
	static float maxCurrentDelta = 0.05f;

	SensorValidator() {
	}

	public static boolean isSuddenJump(double value, double nextValue, double maxDelta) {
		return (nextValue - value > maxDelta);
	}

	public static boolean validateSOCreadings(List<Double> values) 
	{
		return isNull(values) ? validateReadings(values, maxSOCDelta) : false;
	}

	public static boolean validateCurrentreadings(List<Double> values) {
		return isNull(values) ? validateReadings(values, maxCurrentDelta) : false;
	}

	public static boolean validateReadings(List<Double> values, float maxDelta) {
		int lastButOneIndex = values.size() - 1;
		for (int i = 0; i < lastButOneIndex; i++) {
			if (!isSuddenJump(values.get(i), values.get(i + 1), maxDelta)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isNull(List<Double> values)
	{
		return (values.isEmpty() && values != null);
	}
}
