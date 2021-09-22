/*
 * Copyright (c) 2021, ClockClap. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package io.github.cluve.spigot.v1_12;

import io.github.cluve.common.CluveCommon;
import io.github.cluve.common.CommonPlugin;
import io.github.cluve.common.MinecraftVersion;
import io.github.cluve.common.PluginType;
import io.github.cluve.common.annotation.Normalized;
import io.github.cluve.common.annotation.SupportedTypes;
import io.github.cluve.common.annotation.SupportedVersions;
import io.github.cluve.spigot.v1_12.entity.CluvePlayer;
import io.github.cluve.spigot.v1_12.world.CluveWorld;
import org.apache.commons.lang3.Validate;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@SupportedVersions(versions = { MinecraftVersion.V1_12 })
public class CluveSpigot implements CluveCommon {

    private final Plugin spigotPlugin;
    private final CommonPlugin plugin;

    /**
     * Creates new instance of Cluve main ({@link CluveSpigot})
     *
     * @param plugin spigot plugin
     */
    public CluveSpigot(@NotNull Plugin plugin) {
        Validate.notNull(plugin);
        this.spigotPlugin = plugin;
        this.plugin = new CommonPlugin(plugin.getName(), plugin.getDescription().getVersion(), PluginType.SPIGOT);
    }

    @NotNull
    @Override
    public CommonPlugin getPlugin() {
        return plugin;
    }

    @NotNull
    public Plugin getSpigotPlugin() {
        return spigotPlugin;
    }

    @NotNull
    public CluveWorld getCluveWorld(UUID uuid) {
        return CluveWorld.getCluveWorld(uuid, this);
    }

    @NotNull
    public CluvePlayer getCluvePlayer(Player player) {
        return CluvePlayer.getCluvePlayer(player, this);
    }

    @SupportedTypes({
            PluginType.SPIGOT,
            PluginType.PAPER
    })
    @Normalized
    public Vector getDirection(Location from, Location to) {
        double dx = to.getX() - from.getX();
        double dy = to.getY() - from.getY();
        double dz = to.getZ() - from.getZ();
        Vector vector = new Vector(dx, dy, dz);
        return vector.normalize();
    }

    @SupportedTypes({
            PluginType.SPIGOT,
            PluginType.PAPER
    })
    @Normalized
    public Vector getDirection(double yaw, double pitch) {
        Vector vector = new Vector();
        double rx = Math.toRadians(yaw);
        double ry = Math.toRadians(pitch);
        double xz = Math.cos(rx);
        vector.setX(-xz * Math.sin(rx));
        vector.setY(-Math.sin(ry));
        vector.setZ(xz * Math.cos(rx));
        return vector.normalize();
    }

}
