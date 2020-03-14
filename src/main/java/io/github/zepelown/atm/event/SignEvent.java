package io.github.zepelown.atm.event;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class SignEvent implements Listener {
    @EventHandler
    public void sign_change_event(SignChangeEvent e) {
        Player player = e.getPlayer();
        if(!player.isOp())
            return;
        if(e.getLine(0).equalsIgnoreCase("atm")) {
            e.setLine(0, ChatColor.AQUA + "[ATM]");
            e.setLine(1, ChatColor.GRAY + "우클릭으로 사용");
            e.setLine(2, ChatColor.GRAY + "할 수 있습니다.");
            e.getPlayer().sendMessage("ATM 기기를 만들었습니다.");
        }
    }

    @EventHandler
    public void sign_click_event(PlayerInteractEvent e) {
        if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        Player p = e.getPlayer();
        Block b = e.getClickedBlock();
        if(b.getBlockData().getMaterial().name().contains("WALL_SIGN")){
            Sign sign = (Sign) b.getState();
            if (ChatColor.stripColor(sign.getLine(0)).equalsIgnoreCase("[ATM]")) {
                p.sendMessage("ATM 작동");
            }
        }

    }
}
