import java.io.*;
import java.util.*;

public class metroGraph {

	public class branch {
		HashMap<String, Integer> branches = new HashMap<>();
	}

	public static HashMap<String, branch> vertices;

	public metroGraph() {
		vertices = new HashMap<>();
	}

	public void addVertex(String[] stations) {
		for (String station_name : stations) {
			branch bnc = new branch();
			vertices.put(station_name, bnc);
		}
	}

	public void addEdge(String station1, String station2, int fare) {
		branch edge1 = vertices.get(station1);
		branch edge2 = vertices.get(station2);
		edge1.branches.put(station2, fare);
		edge2.branches.put(station1, fare);
	}

	public void display_Stations() {
		System.out.println("\n***********************************************************************\n");
		ArrayList<String> keys = new ArrayList<>(vertices.keySet());
		int i = 1;
		for (String key : keys) {
			System.out.println(i + ". " + key);
			i++;
		}
		System.out.println("\n***********************************************************************\n");
	}

	public void display_Map() {
		System.out.println("\t Delhi Metro Map");
		System.out.println("\t------------------");
		System.out.println("----------------------------------------------------\n");
		ArrayList<String> keys = new ArrayList<>(vertices.keySet());

		for (String key : keys) {
			String str = key + " =>\n";
			branch vtx = vertices.get(key);
			ArrayList<String> vtxnbrs = new ArrayList<>(vtx.branches.keySet());

			for (String nbr : vtxnbrs) {
				str = str + "\t" + nbr + "\t";
				if (nbr.length() < 16)
					str = str + "\t";
				if (nbr.length() < 8)
					str = str + "\t";
				str = str + vtx.branches.get(nbr) + "\n";
			}
			System.out.println(str);
		}
		System.out.println("\t------------------");
		System.out.println("---------------------------------------------------\n");

	}

	public static void station_names(metroGraph graph) {
		String[] stations = { "DWARKA SECTOR 21~BO", "DWARKA~BG", "JANAKPURI WEST~BM", "RAJOURI GARDEN~BP",
				"KIRTI NAGAR~BG", "RAJIV CHOWK~BY", "MANDI HOUSE~BV", "YAMUNA BANK~B", "KARKARDOOMA~BP", "VAISHALI~B",
				"MAYUR VIHAR~BP", "BOTANICAL GARDEN~BM", "NOIDA ELECTRONIC CITY~B", "NEW DELHI~YO",
				"DHANSA BUS STAND~G", "HAUZ KHAS~MY", "KALKAJI MANDIR~MV", "MAJLIS PARK~P", "AZADPUR~PY",
				"NETAJI SUBHASH PLACE~PR", "PUNJABI BAGH WEST~PG", "INA~PY", "LAJPAT NAGAR~PV", "SHIV VIHAR~P",
				"BAHADURGARH CITY PARK~G", "ASHOK PARK~G", "INDERLOK~GR", "SAMAYPUR BADLI~Y", "KASHMERE GATE~YRV",
				"CENTRAL SECRETARIAT~YV", "HUDA CITY CENTER~Y", "ESCORTS MUJESAR~V", "RITHALA~R", "SHAHEED STHAL~R" };
		graph.addVertex(stations);
	}

	public static void create_edges(metroGraph graph) {
		graph.addEdge("DWARKA SECTOR 21~BO", "DWARKA~BG", 8);
		graph.addEdge("DWARKA~BG", "JANAKPURI WEST~BM", 5);
		graph.addEdge("JANAKPURI WEST~BM", "RAJOURI GARDEN~BP", 5);
		graph.addEdge("RAJOURI GARDEN~BP", "KIRTI NAGAR~BG", 3);
		graph.addEdge("KIRTI NAGAR~BG", "RAJIV CHOWK~BY", 7);
		graph.addEdge("RAJIV CHOWK~BY", "MANDI HOUSE~BV", 2);
		graph.addEdge("MANDI HOUSE~BV", "YAMUNA BANK~B", 3);
		graph.addEdge("YAMUNA BANK~B", "KARKARDOOMA~BP", 4);
		graph.addEdge("KARKARDOOMA~BP", "VAISHALI~B", 3);
		graph.addEdge("YAMUNA BANK~B", "MAYUR VIHAR~BP", 2);
		graph.addEdge("MAYUR VIHAR~BP", "BOTANICAL GARDEN~BM", 6);
		graph.addEdge("BOTANICAL GARDEN~BM", "NOIDA ELECTRONIC CITY~B", 8);
		graph.addEdge("DWARKA SECTOR 21~BO", "NEW DELHI~YO", 5);
		graph.addEdge("DWARKA~BG", "DHANSA BUS STAND~G", 3);
		graph.addEdge("JANAKPURI WEST~BM", "HAUZ KHAS~MY", 11);
		graph.addEdge("HAUZ KHAS~MY", "KALKAJI MANDIR~MV", 5);
		graph.addEdge("KALKAJI MANDIR~MV", "BOTANICAL GARDEN~BM", 7);
		graph.addEdge("MAJLIS PARK~P", "AZADPUR~PY", 1);
		graph.addEdge("AZADPUR~PY", "NETAJI SUBHASH PLACE~PR", 2);
		graph.addEdge("NETAJI SUBHASH PLACE~PR", "PUNJABI BAGH WEST~PG", 2);
		graph.addEdge("PUNJABI BAGH WEST~PG", "RAJOURI GARDEN~BP", 2);
		graph.addEdge("RAJOURI GARDEN~BP", "INA~PY", 8);
		graph.addEdge("INA~PY", "LAJPAT NAGAR~PV", 2);
		graph.addEdge("LAJPAT NAGAR~PV", "MAYUR VIHAR~BP", 4);
		graph.addEdge("MAYUR VIHAR~BP", "KARKARDOOMA~BP", 6);
		graph.addEdge("KARKARDOOMA~BP", "SHIV VIHAR~P", 8);
		graph.addEdge("BAHADURGARH CITY PARK~G", "PUNJABI BAGH WEST~PG", 18);
		graph.addEdge("PUNJABI BAGH WEST~PG", "ASHOK PARK~G", 2);
		graph.addEdge("ASHOK PARK~G", "INDERLOK~GR", 1);
		graph.addEdge("ASHOK PARK~G", "KIRTI NAGAR~BG", 2);
		graph.addEdge("SAMAYPUR BADLI~Y", "AZADPUR~PY", 5);
		graph.addEdge("AZADPUR~PY", "KASHMERE GATE~YRV", 6);
		graph.addEdge("KASHMERE GATE~YRV", "NEW DELHI~YO", 3);
		graph.addEdge("NEW DELHI~YO", "RAJIV CHOWK~BY", 1);
		graph.addEdge("RAJIV CHOWK~BY", "CENTRAL SECRETARIAT~YV", 2);
		graph.addEdge("CENTRAL SECRETARIAT~YV", "INA~PY", 4);
		graph.addEdge("INA~PY", "HAUZ KHAS~MY", 3);
		graph.addEdge("HAUZ KHAS~MY", "HUDA CITY CENTER~Y", 12);
		graph.addEdge("KASHMERE GATE~YRV", "MANDI HOUSE~BV", 5);
		graph.addEdge("MANDI HOUSE~BV", "CENTRAL SECRETARIAT~YV", 2);
		graph.addEdge("CENTRAL SECRETARIAT~YV", "LAJPAT NAGAR~PV", 4);
		graph.addEdge("LAJPAT NAGAR~PV", "KALKAJI MANDIR~MV", 4);
		graph.addEdge("KALKAJI MANDIR~MV", "ESCORTS MUJESAR~V", 16);
		graph.addEdge("RITHALA~R", "NETAJI SUBHASH PLACE~PR", 5);
		graph.addEdge("NETAJI SUBHASH PLACE~PR", "INDERLOK~GR", 3);
		graph.addEdge("INDERLOK~GR", "KASHMERE GATE~YRV", 5);
		graph.addEdge("KASHMERE GATE~YRV", "SHAHEED STHAL~R", 15);
	}

	public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

	public ArrayList<String> dijkstra(String source, String destination) {
		HashMap<String, Integer> map = new HashMap<>();
		HashMap<String, Integer> hmp = new HashMap<>();
		HashMap<String, Boolean> visited = new HashMap<>();
		HashMap<String, String> parent = new HashMap<>();
		for (String key : vertices.keySet()) {
			if (key.equals(source)) {
				map.put(key, 0);
				hmp.put(key, 0);
			} else {
				map.put(key, Integer.MAX_VALUE);
			}
		}
		while (!hmp.isEmpty()) {
			hmp = sortByValue(hmp);
			String station_name = "";
			int distance = 0;
			for (Map.Entry<String, Integer> m : hmp.entrySet()) {
				station_name = (String) m.getKey();
				distance = (int) m.getValue();
				break;
			}
			hmp.remove(station_name);
			if (visited.containsKey(station_name)) {
				continue;
			}
			for (String branch_station : vertices.get(station_name).branches.keySet()) {
				int dist = vertices.get(station_name).branches.get(branch_station) + distance;
				if (dist < map.get(branch_station)) {
					map.put(branch_station, dist);
					hmp.put(branch_station, dist);
					parent.put(branch_station, station_name);
				}
			}
			visited.put(station_name, true);
		}
		ArrayList<String> list = new ArrayList<>();
		String child = destination;
		list.add(destination);
		while (!child.equals(source)) {
			child = parent.get(child);
			list.add(child);
		}
		list.add(Integer.toString(map.get(destination)));
		return list;
	}
	public static char common_char(String s1, String s2) {
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) == s2.charAt(0)) {
				return s1.charAt(i);
			}else if(s1.charAt(i) == s2.charAt(1)) {
				return s1.charAt(i);
			}
		}
		return '-';
	}
	public static ArrayList<String> interchanges(ArrayList<String> list) {
		ArrayList<String> code_string = new ArrayList<>();
		for(int i = list.size()-2; i >= 0; i--) {
			String[] arr = list.get(i).split("~");
			code_string.add(arr[1]);
		}
		int counter = 0;
		for(int j = 1; j < code_string.size()-1; j++) {
			String prev = code_string.get(j-1);
			String curr = code_string.get(j);
			char line1 = common_char(prev, curr);
			String next = code_string.get(j+1);
			char line2 = common_char(curr, next);
			System.out.println(line1 + " " + line2);
			if(line1 != line2) {
				list.add(list.size()-(j+2), "line change to " + line2);
				counter++;
			}
		}
		list.add(Integer.toString(counter));
		return list;
//		String curr
//		String next
	}

	public static void main() {
		System.out.println("Welcome to Delhi Metro");
		System.out.println("How Can we Help You!!");
		System.out.println("1) DISPLAY MAJOR INTERSECTING STATIONS");
		System.out.println("2) DISPLAY MAP OF DELHI METRO");
		System.out.println("3) GET MINIMUM TIME TO TRAVEL BETWEEN TWO STATIONS");
		System.out.println("4) GET SHORTEST ROUTE BETWEEN TWO STATIONS");
		System.out.println();
		System.out.print("Please choose from the above given choices : ");
	}

	public static boolean station_check(String s1, String s2) {
		if (vertices.containsKey(s1) && vertices.containsKey(s2)) {
			return true;
		}
		return false;
	}

	public static void Input3(BufferedReader scn, metroGraph graph) throws IOException {
		System.out.print("Enter START STATION : ");
		String s1 = scn.readLine().toUpperCase();
		System.out.print("Enter DESTINATION STATION : ");
		String s2 = scn.readLine().toUpperCase();
		if (station_check(s1, s2)) {
			ArrayList<String> list = graph.dijkstra(s1, s2);
			System.out.println("MINIMUM TIME : " + list.get(list.size() - 1) + " minutes");
		} else {
			System.out.println("Invalid Station Entries!!");
			System.out.println("Try Again!!");
			System.out.println();
			Input3(scn, graph);
		}

	}

	public static void Input4(BufferedReader scn, metroGraph graph) throws IOException {
		System.out.print("Enter START STATION : ");
		String s1 = scn.readLine().toUpperCase();
		System.out.print("Enter DESTINATION STATION : ");
		String s2 = scn.readLine().toUpperCase();
		if (station_check(s1, s2)) {
			ArrayList<String> list = graph.interchanges(graph.dijkstra(s1, s2));
			for (int i = list.size() - 3; i >= 0; i--) {
				if (i == 0) {
					System.out.println(list.get(i));
					break;
				}
//				if(list.get(i-1).equals("line change to ")) {
//					
//				}
				System.out.println(list.get(i));
				System.out.println("||");
				System.out.println("\\/");
			}
		} else {
			System.out.println("Invalid Station Entries!!");
			System.out.println("Try Again!!");
			System.out.println();
			Input4(scn, graph);
		}

	}

	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		metroGraph graph = new metroGraph();
		station_names(graph);
		create_edges(graph);
		main();
		int input = 0;
		try {
			input = scn.nextInt();
		} catch (Exception e) {
			System.out.println("Invalid Input");
			System.out.println("Try Again!!");
			System.out.println();
			main();
		}
		;
		if (input == 1) {
			graph.display_Stations();
		} else if (input == 2) {
			graph.display_Map();
		} else if (input == 3) {
			Input3(inp, graph);
		} else if (input == 4) {
			Input4(inp, graph);
		}
		scn.close();
	}
}
