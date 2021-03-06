package codingstudy.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TravelRoute_DFS {

    public static void main(String[] args) {
        TravelRoute_DFS tr = new TravelRoute_DFS();
        String[][] tickets = new String[][]{{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};
        String[] result = tr.solution(tickets);
        for (String e : result)
            System.out.println(e);
    }

    private List<List<String>> results = new ArrayList();

    public String[] solution(String[][] tickets) {

        for (String[] ticket : tickets) {
            if (!ticket[0].equals("ICN")) continue;

            List<String[]> ticketsList = new ArrayList(Arrays.asList(tickets));
            List<String> routeList = new ArrayList();

            dfs(ticket, ticketsList, routeList);
        }

        return getResult();
    }

    private void dfs(String[] currentTicket, List<String[]> ticketsList, List<String> routeList) {

        String departure = currentTicket[0];
        String arrival = currentTicket[1];

        routeList.add(departure);

        ticketsList.remove(currentTicket);

        if (ticketsList.size() == 0) {
            routeList.add(arrival);
            results.add(routeList);
            return;
        }

        List<String[]> clonesOfTickets = new ArrayList<>(ticketsList);

        for (String[] ticket : clonesOfTickets) {
            String nextDeparture = ticket[0];
            if (!nextDeparture.equals(arrival)) continue;

            List<String> clonesOfRoutes = new ArrayList<>(routeList);
            List<String[]> clonesOfTickets2 = new ArrayList<>(clonesOfTickets);

            dfs(ticket, clonesOfTickets2, clonesOfRoutes);
        }

    }

    private String[] getResult() {
        String[][] answer = new String[results.size()][results.get(0).size()];

        for (int i = 0; i < results.size(); i++)
            for (int j = 0; j < results.get(i).size(); j++)
                answer[i][j] = results.get(i).get(j);

        Arrays.sort(answer, (o1, o2) -> {
            for (int i = 0; i < o1.length; i++){
                if (!o1[i].equals(o2[i]))
                    return o1[i].compareTo(o2[i]);
            }
            return 0;
        });

        return answer[0];
    }
}
