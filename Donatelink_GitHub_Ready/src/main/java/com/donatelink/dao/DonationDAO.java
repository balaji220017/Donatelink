package com.donatelink.dao;

import com.donatelink.model.Donation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DonationDAO {
    public void insert(Donation d) throws Exception {
        try (Connection c = DBUtil.getConnection()) {
            String sql = "INSERT INTO donations(user_id, amount, note) VALUES (?,?,?)";
            try (PreparedStatement ps = c.prepareStatement(sql)) {
                if (d.getUserId() == null) ps.setNull(1, Types.INTEGER);
                else ps.setInt(1, d.getUserId());
                ps.setDouble(2, d.getAmount());
                ps.setString(3, d.getNote());
                ps.executeUpdate();
            }
        }
    }

    public List<Donation> listAll() throws Exception {
        List<Donation> res = new ArrayList<>();
        try (Connection c = DBUtil.getConnection()) {
            String sql = "SELECT id, user_id, amount, note FROM donations ORDER BY donated_at DESC";
            try (PreparedStatement ps = c.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Donation d = new Donation();
                    d.setId(rs.getInt("id"));
                    d.setUserId(rs.getObject("user_id") == null ? null : rs.getInt("user_id"));
                    d.setAmount(rs.getDouble("amount"));
                    d.setNote(rs.getString("note"));
                    res.add(d);
                }
            }
        }
        return res;
    }
}
