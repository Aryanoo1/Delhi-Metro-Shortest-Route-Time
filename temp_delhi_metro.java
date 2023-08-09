import java.util.*;
import java.io.*;

public class temp_delhi_metro {
	public class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	static HashMap<String, Vertex> vtces;

	public temp_delhi_metro() {
		vtces = new HashMap<>();
	}

	public void addVertex(String vname) {
		Vertex vtx = new Vertex();
		vtces.put(vname, vtx);
	}

	public void addEdge(String vname1, String vname2, int value) {
		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.put(vname2, value);
		vtx2.nbrs.put(vname1, value);
	}

	public void display_Map() {
		System.out.println("\t Delhi Metro Map");
		System.out.println("\t------------------");
		System.out.println("----------------------------------------------------\n");
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());

		for (String key : keys) {
			String str = key + " =>\n";
			Vertex vtx = vtces.get(key);
			ArrayList<String> vtxnbrs = new ArrayList<>(vtx.nbrs.keySet());

			for (String nbr : vtxnbrs) {
				str = str + "\t" + nbr + "\t";
				if (nbr.length() < 16)
					str = str + "\t";
				if (nbr.length() < 8)
					str = str + "\t";
				str = str + vtx.nbrs.get(nbr) + "\n";
			}
			System.out.println(str);
		}
		System.out.println("\t------------------");
		System.out.println("---------------------------------------------------\n");

	}

	public void display_Stations() {
		System.out.println("\n***********************************************************************\n");
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		int i = 1;
		for (String key : keys) {
			System.out.println(i + ". " + key);
			i++;
		}
		System.out.println("\n***********************************************************************\n");
	}

	private class Pair {
		String vname;
		String psf;
		int min_dis;
		int min_time;
	}

	public String Get_Minimum_Distance(String src, String dst) {
		int min = Integer.MAX_VALUE;
		// int time = 0;
		String ans = "";
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();

		// create a new pair
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src + "  ";
		sp.min_dis = 0;
		sp.min_time = 0;

		// put the new pair in stack
		stack.addFirst(sp);

		// while stack is not empty keep on doing the work
		while (!stack.isEmpty()) {
			// remove a pair from stack
			Pair rp = stack.removeFirst();

			if (processed.containsKey(rp.vname)) {
				continue;
			}

			// processed put
			processed.put(rp.vname, true);

			// if there exists a direct edge b/w removed pair and destination vertex
			if (rp.vname.equals(dst)) {
				int temp = rp.min_dis;
				if (temp < min) {
					ans = rp.psf;
					min = temp;
				}
				continue;
			}

			Vertex rpvtx = vtces.get(rp.vname);
			ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

			for (String nbr : nbrs) {
				// process only unprocessed nbrs
				if (!processed.containsKey(nbr)) {

					// make a new pair of nbr and put in queue
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr + "  ";
					np.min_dis = rp.min_dis + rpvtx.nbrs.get(nbr);
					// np.min_time = rp.min_time + 120 + 40*rpvtx.nbrs.get(nbr);
					stack.addFirst(np);
				}
			}
		}
		ans = ans + Integer.toString(min);
		System.out.println("---------------------- the ans(result) variable is -----------------------");
		System.out.println(ans);
		return ans;
	}

	public ArrayList<String> get_Interchanges(String str) {
		System.out.println("------------------- the str variable is ----------------------------");
		System.out.println(str);
		ArrayList<String> arr = new ArrayList<>();
		String res[] = str.split("  ");
		arr.add(res[0]);
		int count = 0;
		for (int i = 1; i < res.length - 1; i++) {
			int index = res[i].indexOf('~');
			String s = res[i].substring(index + 1);

			if (s.length() == 2) {
				String prev = res[i - 1].substring(res[i - 1].indexOf('~') + 1);
				String next = res[i + 1].substring(res[i + 1].indexOf('~') + 1);

				if (prev.equals(next)) {
					arr.add(res[i]);
				} else {
					arr.add(res[i] + " ==> " + res[i + 1]);
					i++;
					count++;
				}
			} else {
				arr.add(res[i]);
			}
		}
		arr.add(Integer.toString(count));
		arr.add(res[res.length - 1]);
		System.out.println("---------------------------- the arr arraylist returned is --------------------------");
		System.out.println(arr);
		return arr;
	}

	public static void Create_Metro_Map(temp_delhi_metro g) {
		g.addVertex("Noida Sector 62~B");
		g.addVertex("Botanical Garden~B");
		g.addVertex("Yamuna Bank~B");
		g.addVertex("Rajiv Chowk~BY");
		g.addVertex("Vaishali~B");
		g.addVertex("Moti Nagar~B");
		g.addVertex("Janak Puri West~BO");
		g.addVertex("Dwarka Sector 21~B");
		g.addVertex("Huda City Center~Y");
		g.addVertex("Saket~Y");
		g.addVertex("Vishwavidyalaya~Y");
		g.addVertex("Chandni Chowk~Y");
		g.addVertex("New Delhi~YO");
		g.addVertex("AIIMS~Y");
		g.addVertex("Shivaji Stadium~O");
		g.addVertex("DDS Campus~O");
		g.addVertex("IGI Airport~O");
		g.addVertex("Rajouri Garden~BP");
		g.addVertex("Netaji Subhash Place~PR");
		g.addVertex("Punjabi Bagh West~P");

		g.addEdge("Noida Sector 62~B", "Botanical Garden~B", 8);
		g.addEdge("Botanical Garden~B", "Yamuna Bank~B", 10);
		g.addEdge("Yamuna Bank~B", "Vaishali~B", 8);
		g.addEdge("Yamuna Bank~B", "Rajiv Chowk~BY", 6);
		g.addEdge("Rajiv Chowk~BY", "Moti Nagar~B", 9);
		g.addEdge("Moti Nagar~B", "Janak Puri West~BO", 7);
		g.addEdge("Janak Puri West~BO", "Dwarka Sector 21~B", 6);
		g.addEdge("Huda City Center~Y", "Saket~Y", 15);
		g.addEdge("Saket~Y", "AIIMS~Y", 6);
		g.addEdge("AIIMS~Y", "Rajiv Chowk~BY", 7);
		g.addEdge("Rajiv Chowk~BY", "New Delhi~YO", 1);
		g.addEdge("New Delhi~YO", "Chandni Chowk~Y", 2);
		g.addEdge("Chandni Chowk~Y", "Vishwavidyalaya~Y", 5);
		g.addEdge("New Delhi~YO", "Shivaji Stadium~O", 2);
		g.addEdge("Shivaji Stadium~O", "DDS Campus~O", 7);
		g.addEdge("DDS Campus~O", "IGI Airport~O", 8);
		g.addEdge("Moti Nagar~B", "Rajouri Garden~BP", 2);
		g.addEdge("Punjabi Bagh West~P", "Rajouri Garden~BP", 2);
		g.addEdge("Punjabi Bagh West~P", "Netaji Subhash Place~PR", 3);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		temp_delhi_metro g = new temp_delhi_metro();
		Create_Metro_Map(g);
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("ENTER THE SOURCE AND DESTINATION STATIONS");
		String s1 = "Dwarka Sector 21~B";
		String s2 = "Netaji Subhash Place~PR";

		HashMap<String, Boolean> processed2 = new HashMap<>();
		ArrayList<String> str = g.get_Interchanges(g.Get_Minimum_Distance(s1, s2));
		int len = str.size();
//		System.out.println("SOURCE STATION : " + s1);
//		System.out.println("SOURCE STATION : " + s2);
		System.out.println("DISTANCE : " + str.get(len - 1));
		System.out.println("NUMBER OF INTERCHANGES : " + str.get(len - 2));
		// System.out.println(str);
		System.out.println("~~~~~~~~~~~~~");
		System.out.println("START  ==>  " + str.get(0));
		for (int i = 1; i < len - 3; i++) {
			System.out.println(str.get(i));
		}
		System.out.print(str.get(len - 3) + "   ==>    END");
		System.out.println("\n~~~~~~~~~~~~~");
	}

}
