package practice_7.user_monitor;

import java.util.HashSet;

public class UserMonitor {
    // хранение уникальных сессии
    private HashSet<String> sessions;

    public UserMonitor() {
        this.sessions = new HashSet<>();
    }

    public void addNewSession(String session) {
        sessions.add(session);
    }

    // доступ к сессии
    public HashSet<String> getSessions() {
        return this.sessions;
    }

    public void printSessions() {
        System.out.println("Все уникальные сессии:");
        sessions.forEach(System.out::println);
    }
}
