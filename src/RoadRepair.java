

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

class Result {

	/*
	 * Complete the 'getMinCost' function below.
	 *
	 * The function is expected to return a LONG_INTEGER. The function accepts
	 * following parameters: 1. INTEGER_ARRAY employee_id 2. INTEGER_ARRAY job_id
	 */

	public static long getMinCost(List<Integer> employee_id, List<Integer> job_id) {
		Collections.sort(employee_id);
		Collections.sort(job_id);
		int n = employee_id.size();
		long result = 0;
		for (int i = 0; i < n; ++i) {
			if (employee_id.get(i) > job_id.get(i))
				result = result + Math.abs(employee_id.get(i) - job_id.get(i));

			else if (employee_id.get(i) < job_id.get(i))
				result = result + Math.abs(employee_id.get(i) - job_id.get(i));
		}

		return result;
	}

}

public class RoadRepair {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int employee_idCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> employee_id = IntStream.range(0, employee_idCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int job_idCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> job_id = IntStream.range(0, job_idCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		long result = Result.getMinCost(employee_id, job_id);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
