package io.github.zepelown.economy;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class EconomyManager {
    private HashMap<UUID, Double> accounts = new HashMap<>();

    public void setBalance(Player player, double amount) {
        UUID id = player.getUniqueId();
        accounts.put(id, amount);
    }

    public HashMap<UUID, Double> getAccounts() {
        return accounts;
    }

    public Double getSomeoneAccount(Player player) {
        UUID id = player.getUniqueId();
        return accounts.get(id);
    }

    public Boolean hasAccount(Player player){
        UUID id = player.getUniqueId();
        if(accounts.containsKey(id))
            return true;
        return false;
    }

    public void addBalance(Player player, double amount) {
        UUID id = player.getUniqueId();
        double temp = accounts.get(id);
        accounts.put(id, temp + amount);
    }

    public void deleteAccount(Player player) {
        UUID id = player.getUniqueId();
        accounts.remove(id);
    }
}
