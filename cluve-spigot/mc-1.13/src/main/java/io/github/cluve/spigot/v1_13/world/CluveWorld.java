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

package io.github.cluve.spigot.v1_13.world;

import io.github.cluve.common.CluveCommon;
import io.github.cluve.common.MinecraftVersion;
import io.github.cluve.common.PluginType;
import io.github.cluve.common.annotation.SupportedTypes;
import io.github.cluve.common.annotation.SupportedVersions;
import io.github.cluve.spigot.v1_13.CluveSpigot;
import org.apache.commons.lang3.Validate;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SupportedTypes({
        PluginType.SPIGOT,
        PluginType.PAPER
})
@SupportedVersions(versions = { MinecraftVersion.V1_13 })
public class CluveWorld {

    private static Map<UUID, CluveWorld> worlds = new HashMap<>();

    private final CluveSpigot cluve;
    private final World world;

    /**
     * Creates new instance of {@link CluveWorld}
     *
     * @param cluve Cluve main class ({@link CluveSpigot})
     * @param world target world
     */
    public CluveWorld(@NotNull CluveCommon cluve, @NotNull World world) {
        if(!(cluve instanceof CluveSpigot)) throw new IllegalArgumentException("cluve is not instance of CluveSpigot");
        Validate.notNull(cluve);
        Validate.notNull(world);
        this.cluve = (CluveSpigot) cluve;
        this.world = world;
        worlds.put(world.getUID(), this);
    }

    @NotNull
    public static CluveWorld getCluveWorld(@NotNull UUID uuid, @NotNull CluveCommon cluve) {
        Validate.notNull(uuid);
        Validate.notNull(cluve);
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

    public void fillBlocks(int x, int y, int z, FillPattern pattern) {
        Material[] blocks = pattern.pattern;
        int l = 0;
        for(int i = 0; i < pattern.size.x; i++) {
            for(int j = 0; j < pattern.size.y; j++) {
                for(int k = 0; k < pattern.size.z; k++, l++) {
                    try {
                        setBlock(x + i, y + j, z + k, blocks[l]);
                    } catch (IndexOutOfBoundsException ignored) { }
                }
            }
        }
    }

    @NotNull
    public World getWorld() {
        return world;
    }

    @NotNull
    public CluveSpigot getCluve() {
        return cluve;
    }

    public boolean equals(Object obj) {
        if(obj instanceof CluveWorld) {
            CluveWorld w = (CluveWorld) obj;
            return match(this.getWorld(), w.getWorld());
        }
        return false;
    }

    public static boolean match(World w1, World w2) {
        return w1.getUID().equals(w2.getUID());
    }

}
