package com.example.backend.repository;

import com.example.backend.model.custom.IUserTotalPoints;
import com.example.backend.model.custom.UserTotalPoints;
import com.example.backend.model.entity.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer, Integer> {

    @Query(value = "WITH unique_exercises AS (" +
            "    SELECT DISTINCT ua.user_id, ua.exercise_id, e.points" +
            "    FROM user_answer ua " +
            "    JOIN exercise e ON e.id = ua.exercise_id " +
            "    WHERE date_part('week', ua.time_done) = date_part('week', current_date) " +
            "      AND date_part('year', ua.time_done) = date_part('year', current_date)" +
            ")" +
            "SELECT ROW_NUMBER() OVER (ORDER BY SUM(ue.points) DESC) AS position, " +
            "       u.username, u.firstname, u.lastname, u.country, SUM(ue.points) AS points " +
            "FROM unique_exercises ue " +
            "JOIN \"user\" u ON u.id = ue.user_id " +
            "GROUP BY u.username, u.firstname, u.lastname, u.country " +
            "ORDER BY points DESC " +
            "limit 3",
            nativeQuery = true)
    List<IUserTotalPoints> getWeekRankTop3();
    @Query(value = "WITH unique_exercises AS (" +
            "    SELECT DISTINCT ua.user_id, ua.exercise_id, e.points" +
            "    FROM user_answer ua " +
            "    JOIN exercise e ON e.id = ua.exercise_id " +
            "    WHERE date_part('week', ua.time_done) = date_part('week', current_date) " +
            "      AND date_part('year', ua.time_done) = date_part('year', current_date)" +
            ")" +
            "SELECT ROW_NUMBER() OVER (ORDER BY SUM(ue.points) DESC) AS position, " +
            "       u.username, u.firstname, u.lastname, u.country, SUM(ue.points) AS points " +
            "FROM unique_exercises ue " +
            "JOIN \"user\" u ON u.id = ue.user_id " +
            "GROUP BY u.username, u.firstname, u.lastname, u.country " +
            "ORDER BY points DESC ",
            nativeQuery = true)
    List<IUserTotalPoints> getWeekRank();

    @Query("select ua from UserAnswer ua " +
            " join User u on u.id = ua.user.id" +
            " join Exercise e on  e.id = ua.exercise.id" +
            " join ExerciseList el on el.id = e.exerciseList.id " +
            " where u.id = :userId and el.id = :exerciseListId")
    List<UserAnswer> findUserAnswersByUserIdAndExerciseListId(Integer userId, Integer exerciseListId);
}
