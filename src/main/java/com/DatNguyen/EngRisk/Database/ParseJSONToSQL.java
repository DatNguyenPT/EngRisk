package com.DatNguyen.EngRisk.Database;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParseJSONToSQL{
    JSONFormat jsonFormat;
    public ParseJSONToSQL() throws IOException {this.jsonFormat = jsonFormat;}

    public void dataQueries() throws IOException, ParseException, SQLException {
        JSONObject data = jsonFormat.getJSON();
        StringBuilder sb = new StringBuilder();
        List<String>result = new ArrayList<>();
        data.keySet().forEach(keyStr -> {
            boolean lastKey = false;
            if (keyStr.equals("exampleSentence")){
                lastKey = true;
            }
            Object keyvalue = data.get(keyStr);
            if (lastKey){
                sb.append(keyvalue);
                result.add(sb.toString());
                sb.setLength(0);
            }else{
                sb.append(keyvalue + ", ");
            }
        });
        ConnectMysql connect = new ConnectMysql();

        // Connection to your database
        Connection con = connect.getConnection();
        for (String value : result){
            String query = "INSERT INTO VOCAB ('category', 'words', 'wordType', 'pronoun', 'exampleSentence')";
            query += " " + value;
            PreparedStatement statement = con.prepareStatement(query);
            statement.executeUpdate();
        }
        // Close the connection
        con.close();
    }
}