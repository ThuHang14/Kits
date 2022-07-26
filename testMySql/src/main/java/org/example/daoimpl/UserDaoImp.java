package org.example.daoimpl;

import org.example.dao.UserDao;
import org.example.model.User;
import org.example.ultils.DBCconnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImp implements UserDao {
    public User getUserByEmailAndPassword(String mail, String pass) {

        try {
            DBCconnection dbc = new DBCconnection();
            dbc.connectDB();
//            b2: dinh nghia truy van va thuc hien truy van
            String sql = "SELECT * from users WHERE email = ? AND passwords = ? ";
//            PreparedStatement ps = conn.prepareStatement(sql);
            PreparedStatement ps = dbc.getConn().prepareStatement(sql);

            ps.setString(1, mail);
            ps.setString(2, pass);


            ResultSet rs = ps.executeQuery();
//          b3 :  xu li ket qua tra ve
            if (rs.next()) {
                User u = new User();
                u.setEmail(rs.getString("email"));
                u.setFirtName(rs.getString("firtname"));
                u.setLastName(rs.getString("lastname"));
                u.setAddress(rs.getString("address"));
                u.setDod(rs.getDate("dod"));
                u.setPhone(rs.getString("phone"));
                u.setSex(rs.getBoolean("sex"));
                u.setActive(rs.getBoolean("active"));

                dbc.disConnectDb();

                return u;

            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("ket noi that bai");
        }
        return null;
    }


}
