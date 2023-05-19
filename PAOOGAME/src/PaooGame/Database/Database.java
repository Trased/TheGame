package PaooGame.Database;

import PaooGame.RefLinks;

import java.sql.*;

public class Database {
    private Connection c = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private int levelsFinished;
    private RefLinks ref;
    public Database(RefLinks ref){
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:theDB.db");
            stmt = c.createStatement();
            this.ref = ref;

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " +e.getMessage());
            System.exit(0);
        }
        System.out.println("Database opened!");
    }
    public void DatabaseNewGame()  {
        String sql = "CREATE TABLE IF NOT EXISTS Game (" +
                "id INTEGER PRIMARY KEY, " +
                "levelsFinished INTEGER," +
                "mapID INTEGER," +
                "HeroX REAL," +
                "HeroY REAL," +
                "HeroHealth INTEGER" +
                ");";
        try{
            stmt.execute("DROP TABLE IF EXISTS Game;");
            stmt.execute(sql);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void DatabaseLoadGame() {
        try {
            if (GameExists()) {
                String selectQuery = "SELECT levelsFinished , mapID , HeroX , HeroY , HeroHealth FROM Game";
                rs = stmt.executeQuery(selectQuery);
                while (rs.next()) {
                    int levelsFinished = rs.getInt("levelsFinished");
                    int mapID = rs.getInt("mapID");
                    float heroX = rs.getFloat("HeroX");
                    float heroY = rs.getFloat("HeroY");
                    int heroHealth = rs.getInt("HeroHealth");
                    ref.GetGame().GetPlayState().GetHero().SetX(heroX);
                    ref.GetGame().GetPlayState().GetHero().SetX(heroY);
                    ref.GetGame().GetPlayState().GetHero().SetHealth(heroHealth);
                    ref.GetGame().GetPlayState().SetLevelFinished(levelsFinished);
                    ref.GetMap().setMapID(mapID);
                    return;
                }
            }
            DatabaseNewGame();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private boolean GameExists(){
        try{
            String sqlQuery = "SELECT 1 FROM Game LIMIT 1;";
            ResultSet resultSet = stmt.executeQuery(sqlQuery);
            return resultSet.getBoolean(1);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    public void DatabaseSaveGame(){
        String sqlStatement;
        if(GameExists()) {
            sqlStatement = "UPDATE Game SET levelsFinished = ?, mapID = ?, HeroX = ?, HeroY = ?, HeroHealth = ?;";
        }else {
            sqlStatement = "INSERT INTO Game(levelsFinished , mapID , HeroX , HeroY , HeroHealth) VALUES (?, ?, ?, ?, ?);";
        }
        try {
            PreparedStatement pstmt = c.prepareStatement(sqlStatement);
            int newLevelsFinished = ref.GetGame().GetPlayState().GetLevelFinished();
            int newMapID = ref.GetMap().getMapID();
            float newHeroX = ref.GetGame().GetPlayState().GetHero().GetX();
            float newHeroY = ref.GetGame().GetPlayState().GetHero().GetY();
            int newHeroHealth = ref.GetGame().GetPlayState().GetHero().GetHealth();
            System.out.println(newHeroX + " " + newHeroY + " " + newHeroHealth + " " + newMapID + " " + newLevelsFinished);
            pstmt.setInt(1, newLevelsFinished);
            pstmt.setInt(2, newMapID);
            pstmt.setFloat(3, newHeroX);
            pstmt.setFloat(4, newHeroY);
            pstmt.setInt(5, newHeroHealth);
            pstmt.executeUpdate();
            System.out.println("DB UPDATED");
            pstmt.close();
            c.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public int getLevelsFinished(){
        return levelsFinished;
    }
}
