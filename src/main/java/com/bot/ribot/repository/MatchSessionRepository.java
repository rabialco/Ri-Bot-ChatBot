package com.bot.ribot.repository;

import com.bot.ribot.model.MatchSession;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@SpringBootApplication
public interface MatchSessionRepository extends JpaRepository<MatchSession, String> {
    @Query(value = "SELECT * FROM LINE_USER LU, MATCH_SESSION MS WHERE USER_ID = ?1"
            + "AND MS.USERFINDER_USER_ID = LU.USER_ID", nativeQuery = true)
    MatchSession findLineUserByFinderUserId(String userID);

    @Query(value = "SELECT * FROM LINE_USER LU, MATCH_SESSION MS WHERE USER_ID = ?1"
            + "AND MS.USERRIVAL_USER_ID = LU.USER_ID", nativeQuery = true)
    MatchSession findLineUserByRivalId(String userID);

    @Query(value = "SELECT * FROM MATCH_SESSION WHERE MATCH_ID = ?1 ", nativeQuery = true)
    MatchSession findSessionByMatchId(long matchId);

    @Query(value = "SELECT state FROM LINE_USER WHERE USER_ID = ?1", nativeQuery = true)
    String findStateById(String userID);

    @Query(value = "SELECT * FROM MATCH_SESSION WHERE userRival = NULL", nativeQuery = true)
    List<MatchSession> findAvailableRival();
}
