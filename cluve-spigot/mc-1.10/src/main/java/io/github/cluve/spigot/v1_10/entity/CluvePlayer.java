/*
 * Copyright (c) 2021, ClockClap. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package io.github.cluve.spigot.v1_10.entity;

import io.github.cluve.common.CluveCommon;
import io.github.cluve.common.MinecraftVersion;
import io.github.cluve.common.PluginType;
import io.github.cluve.common.annotation.RecommendedDouble;
import io.github.cluve.common.annotation.SupportedTypes;
import io.github.cluve.common.annotation.SupportedVersions;
import io.github.cluve.spigot.v1_10.CluveSpigot;
import io.github.cluve.spigot.v1_10.world.BlockShape;
import io.github.cluve.spigot.v1_10.world.CluveWorld;
import org.apache.commons.lang3.Validate;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SupportedTypes({
        PluginType.SPIGOT,
        PluginType.PAPER
})
@SupportedVersions(versions = { MinecraftVersion.V1_10 })
public class CluvePlayer {

    @Retention(RetentionPolicy.CLASS)
    @Target({
            ElementType.METHOD,
            ElementType.FIELD,
            ElementType.PARAMETER,
            ElementType.LOCAL_VARIABLE,
            ElementType.TYPE_USE})
    @interface FromPlayer {

    }

    @Retention(RetentionPolicy.CLASS)
    @Target({
            ElementType.METHOD,
            ElementType.FIELD,
            ElementType.PARAMETER,
            ElementType.LOCAL_VARIABLE,
            ElementType.TYPE_USE})
    @interface TargetPlayer {

    }

    private static final Map<UUID, CluvePlayer> players = new HashMap<>();

    private final CluveSpigot cluve;
    private final Player player;
    private final String name;
    private Map<Player, String> names;

    public CluvePlayer(@NotNull CluveCommon cluve, @NotNull @TargetPlayer Player player) {
        if(!(cluve instanceof CluveSpigot)) throw new IllegalArgumentException("cluve is not instance of CluveSpigot");
        Validate.notNull(cluve);
        Validate.notNull(player);
        this.cluve = (CluveSpigot) cluve;
        this.player = player;
        this.name = player.getName();
        players.put(player.getUniqueId(), this);
    }

    public static CluvePlayer getCluvePlayer(@NotNull @TargetPlayer Player player, @NotNull CluveCommon cluve) {
        Validate.notNull(player);
        Validate.notNull(cluve);
        UUID id = player.getUniqueId();
        if(players.containsKey(id)) return players.get(id);
        return new CluvePlayer(cluve, player);
    }

    @NotNull
    public CluveSpigot getCluve() {
        return cluve;
    }

    @NotNull
    public Player getPlayer() {
        return player;
    }

    @NotNull
    public String getOriginalName() {
        return name;
    }

    @NotNull
    public String getName(@NotNull @FromPlayer Player from) {
        Validate.notNull(from);
        String n = names.get(from);
        if(n == null) return name;
        return n;
    }

    public void setNameFromMap(@NotNull Map<Player, String> map) {
        Validate.notNull(map);
        names = map;
    }

    public void setName(@NotNull @FromPlayer Player from, @NotNull String name) {
        Validate.notNull(from);
        Validate.notNull(name);
        names.put(from, name);
    }

    public void setName(@NotNull String name) {
        Validate.notNull(name);
        for(Player p : Bukkit.getOnlinePlayers()) setName(p, name);
    }

    private void a(@NotNull String name) {
        Validate.notNull(name);
        try {
            Object gp = player.getClass().getDeclaredMethod("getHandle");
            Field f = gp.getClass().getDeclaredField("name");
            f.setAccessible(true);
            f.set(gp, name);
        } catch (NoSuchFieldException | NoSuchMethodException | IllegalAccessException ignored) { }
    }

    public void hide(@NotNull @FromPlayer Player from) {
        Validate.notNull(from);
        from.hidePlayer(player);
    }

    public void show(@NotNull @FromPlayer Player from) {
        Validate.notNull(from);
        from.showPlayer(player);
    }

    public void updateName(@NotNull @FromPlayer Player from) {
        Validate.notNull(from);
        hide(from);
        a(getName(from));
        show(player);
        a(getOriginalName());
    }

    public void updateName() {
        for(Player p : Bukkit.getOnlinePlayers()) updateName(p);
    }

    public boolean canSeeFrom(@NotNull @FromPlayer Player from, @RecommendedDouble(100) double distance) {
        return canSeePlayer(from, player, distance);
    }

    public boolean canSee(@NotNull @TargetPlayer Player player, @RecommendedDouble(100) double distance) {
        return canSeePlayer(this.player, player, distance);
    }

    public static boolean canSeePlayer(@NotNull @FromPlayer Player from, @NotNull @TargetPlayer Player player, @RecommendedDouble(100) double distance) {
        Validate.notNull(from);
        Validate.notNull(player);
        if(from.canSee(player) && CluveWorld.match(player.getWorld(), from.getWorld())) {
            Collection<PotionEffect> c = player.getActivePotionEffects();
            for(PotionEffect e : c) if (e.getType() == PotionEffectType.INVISIBILITY) return false;

            Location f = from.getEyeLocation();
            Location t = player.getEyeLocation();
            World w = player.getWorld();
            double xf = f.getX();
            double yf = f.getY();
            double zf = f.getZ();
            double xt = t.getX();
            double yt = t.getY();
            double zt = t.getZ();

            double dx = xt - xf;
            double dy = yt - yf;
            double dz = zt - zf;

            Vector v = new Vector(dx, dy, dz);
            double d = v.length();
            if(d > distance) return false;
            double nx = dx / d;
            double ny = dy / d;
            double nz = dz / d;

            for(double cx = xf, cy = yf, cz = zf;
                cx <= xt && cy <= yt && cz <= zt;
                cx += nx,cy += ny,cz += nz) {

                int xi = (int)Math.round(cx);
                int yi = (int)Math.round(cy);
                int zi = (int)Math.round(cz);

                Block b = w.getBlockAt(xi, yi, zi);
                if(!BlockShape.isTransparentBlock(b.getType()) && BlockShape.isInBlock(b, cx, cy, cz)) return false;
            }
            return true;
        }
        return false;
    }

}
