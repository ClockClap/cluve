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

package io.github.clockclap.cluve.spigot.v1_8.world;

import io.github.clockclap.cluve.common.CluveCommon;
import io.github.clockclap.cluve.common.MinecraftVersion;
import io.github.clockclap.cluve.common.PluginType;
import io.github.clockclap.cluve.common.annotation.SupportedTypes;
import io.github.clockclap.cluve.common.annotation.SupportedVersions;
import org.apache.commons.lang3.Validate;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SupportedTypes({
        PluginType.SPIGOT,
        PluginType.PAPER
})
@SupportedVersions(since = MinecraftVersion.V1_8, until = MinecraftVersion.V1_8)
public class CluveWorld {

    private static Map<UUID, CluveWorld> worlds = new HashMap<>();

    private final CluveCommon cluve;
    private final World world;

    public CluveWorld(@NotNull CluveCommon cluve, @NotNull World world) {
        Validate.notNull(cluve);
        Validate.notNull(world);
        this.cluve = cluve;
        this.world = world;
        worlds.put(world.getUID(), this);
    }

    @NotNull
    public static CluveWorld getCluveWorld(UUID uuid, CluveCommon cluve) {
        if(worlds.containsKey(uuid)) return worlds.get(uuid);
        World world = Bukkit.getWorld(uuid);
        if(world == null) throw new IllegalArgumentException("world does not exist");
        return new CluveWorld(cluve, world);
    }

    public void setBlock(int x, int y, int z, Material type) {
        world.getBlockAt(x, y, z).setType(type);
    }

    public void fillBlocks(int x, int y, int z, int dx, int dy, int dz, Material type) {
        for(int i = x; i <= dx; i++) {
            for(int j = y; j <= dy; j++) {
                for(int k = z; k <= dz; k++) {
                    setBlock(i, j, k, type);
                }
            }
        }
    }

    @NotNull
    public World getWorld() {
        return world;
    }

    @NotNull
    public CluveCommon getCluve() {
        return cluve;
    }

}
