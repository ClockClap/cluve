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

package io.github.cluve.spigot.v1_14.world;

import io.github.cluve.common.MinecraftVersion;
import io.github.cluve.common.PluginType;
import io.github.cluve.common.annotation.SupportedTypes;
import io.github.cluve.common.annotation.SupportedVersions;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.type.*;

@SupportedTypes({
        PluginType.SPIGOT,
        PluginType.PAPER
})
@SupportedVersions(versions = { MinecraftVersion.V1_14 })
public final class BlockShape {

    /**
     * Checks the material is slab.
     *
     * @param material target material
     * @return true if the material is slab
     */
    public static boolean isSlab(Material material) {
        if(material == null || !material.isBlock()) return false;
        switch(material) {
            case OAK_SLAB:
            case ACACIA_SLAB:
            case SANDSTONE_SLAB:
            case SPRUCE_SLAB:
            case STONE_SLAB:
            case BIRCH_SLAB:
            case BRICK_SLAB:
            case STONE_BRICK_SLAB:
            case COBBLESTONE_SLAB:
            case DARK_OAK_SLAB:
            case JUNGLE_SLAB:
            case DARK_PRISMARINE_SLAB:
            case NETHER_BRICK_SLAB:
            case PETRIFIED_OAK_SLAB:
            case PRISMARINE_BRICK_SLAB:
            case PRISMARINE_SLAB:
            case QUARTZ_SLAB:
            case RED_SANDSTONE_SLAB:
            case PURPUR_SLAB:
            case ANDESITE_SLAB:
            case CUT_RED_SANDSTONE_SLAB:
            case CUT_SANDSTONE_SLAB:
            case SMOOTH_QUARTZ_SLAB:
            case DIORITE_SLAB:
            case END_STONE_BRICK_SLAB:
            case SMOOTH_RED_SANDSTONE_SLAB:
            case SMOOTH_SANDSTONE_SLAB:
            case SMOOTH_STONE_SLAB:
            case GRANITE_SLAB:
            case MOSSY_COBBLESTONE_SLAB:
            case MOSSY_STONE_BRICK_SLAB:
            case POLISHED_ANDESITE_SLAB:
            case POLISHED_DIORITE_SLAB:
            case POLISHED_GRANITE_SLAB:
            case RED_NETHER_BRICK_SLAB:
                return true;
            default:
                return false;
        }
    }

    /**
     * Checks the material is stairs.
     *
     * @param material target material
     * @return true if the material is stairs
     */
    public static boolean isStairs(Material material) {
        if(material == null || !material.isBlock()) return false;
        switch(material) {
            case SANDSTONE_STAIRS:
            case SPRUCE_STAIRS:
            case ACACIA_STAIRS:
            case BRICK_STAIRS:
            case COBBLESTONE_STAIRS:
            case BIRCH_STAIRS:
            case PURPUR_STAIRS:
            case STONE_BRICK_STAIRS:
            case DARK_OAK_STAIRS:
            case QUARTZ_STAIRS:
            case DARK_PRISMARINE_STAIRS:
            case JUNGLE_STAIRS:
            case NETHER_BRICK_STAIRS:
            case OAK_STAIRS:
            case PRISMARINE_BRICK_STAIRS:
            case PRISMARINE_STAIRS:
            case RED_SANDSTONE_STAIRS:
            case STONE_STAIRS:
            case SMOOTH_QUARTZ_STAIRS:
            case SMOOTH_RED_SANDSTONE_STAIRS:
            case SMOOTH_SANDSTONE_STAIRS:
            case ANDESITE_STAIRS:
            case DIORITE_STAIRS:
            case END_STONE_BRICK_STAIRS:
            case GRANITE_STAIRS:
            case MOSSY_COBBLESTONE_STAIRS:
            case MOSSY_STONE_BRICK_STAIRS:
            case POLISHED_ANDESITE_STAIRS:
            case POLISHED_DIORITE_STAIRS:
            case POLISHED_GRANITE_STAIRS:
            case RED_NETHER_BRICK_STAIRS:
                return true;
            default:
                return false;
        }
    }

    public static boolean isWall(Material material) {
        if(material == null || !material.isBlock()) return false;
        switch (material) {
            case ANDESITE_WALL:
            case COBBLESTONE_WALL:
            case BRICK_WALL:
            case DIORITE_WALL:
            case GRANITE_WALL:
            case END_STONE_BRICK_WALL:
            case MOSSY_COBBLESTONE_WALL:
            case MOSSY_STONE_BRICK_WALL:
            case NETHER_BRICK_WALL:
            case PRISMARINE_WALL:
            case RED_NETHER_BRICK_WALL:
            case RED_SANDSTONE_WALL:
            case SANDSTONE_WALL:
            case STONE_BRICK_WALL:
                return true;
            default:
                return false;
        }
    }

    /**
     * Checks player can pass through the material.
     *
     * @param material target material
     * @return true if player can pass through the material
     */
    @SuppressWarnings({ "deprecation" })
    public static boolean isTransparent(Material material) {
        if(material == null || !material.isBlock()) return false;
        return !isHead(material) && (material.isTransparent() ||
                isSign(material) || isBanner(material));
    }

    public static boolean isSign(Material material) {
        if(material == null || !material.isBlock()) return false;
        switch (material) {
            case SPRUCE_SIGN:
            case ACACIA_SIGN:
            case SPRUCE_WALL_SIGN:
            case BIRCH_SIGN:
            case ACACIA_WALL_SIGN:
            case BIRCH_WALL_SIGN:
            case JUNGLE_SIGN:
            case DARK_OAK_SIGN:
            case OAK_SIGN:
            case DARK_OAK_WALL_SIGN:
            case JUNGLE_WALL_SIGN:
            case OAK_WALL_SIGN:
                return true;
            default:
                return false;
        }
    }

    public static boolean isHead(Material material) {
        if(material == null || !material.isBlock()) return false;
        switch (material) {
            //<editor-fold defaultstate="collapsed" desc="isHead">
            case CREEPER_HEAD:
            case DRAGON_HEAD:
            case PISTON_HEAD:
            case PLAYER_HEAD:
            case CREEPER_WALL_HEAD:
            case ZOMBIE_HEAD:
            case DRAGON_WALL_HEAD:
            case PLAYER_WALL_HEAD:
            case ZOMBIE_WALL_HEAD:
            //</editor-fold>
                return true;
            default:
                return false;
        }
    }

    public static boolean isBanner(Material material) {
        if(material == null || !material.isBlock()) return false;
        switch (material) {
            //<editor-fold defaultstate="collapsed" desc="isBanner">
            case BLACK_BANNER:
            case BLUE_BANNER:
            case BROWN_BANNER:
            case BLACK_WALL_BANNER:
            case BLUE_WALL_BANNER:
            case CYAN_BANNER:
            case BROWN_WALL_BANNER:
            case GRAY_BANNER:
            case GREEN_BANNER:
            case CYAN_WALL_BANNER:
            case GRAY_WALL_BANNER:
            case GREEN_WALL_BANNER:
            case LIGHT_BLUE_BANNER:
            case LIME_BANNER:
            case LIGHT_BLUE_WALL_BANNER:
            case LIGHT_GRAY_BANNER:
            case MAGENTA_BANNER:
            case ORANGE_BANNER:
            case PINK_BANNER:
            case LIGHT_GRAY_WALL_BANNER:
            case LIME_WALL_BANNER:
            case MAGENTA_WALL_BANNER:
            case PURPLE_BANNER:
            case RED_BANNER:
            case ORANGE_WALL_BANNER:
            case PINK_WALL_BANNER:
            case WHITE_BANNER:
            case PURPLE_WALL_BANNER:
            case YELLOW_BANNER:
            case RED_WALL_BANNER:
            case WHITE_WALL_BANNER:
            case YELLOW_WALL_BANNER:
            //</editor-fold>
                return true;
            default:
                return false;
        }
    }

    /**
     * Checks the material is fence.
     *
     * @param material target material
     * @return true if the material is fence
     */
    public static boolean isFence(Material material) {
        if(material == null || !material.isBlock()) return false;
        switch (material) {
            case ACACIA_FENCE:
            case BIRCH_FENCE:
            case JUNGLE_FENCE:
            case DARK_OAK_FENCE:
            case OAK_FENCE:
            case NETHER_BRICK_FENCE:
            case SPRUCE_FENCE:
            case IRON_BARS:
                return true;
            default:
                return false;
        }
    }

    /**
     * Checks the material is fence gate.
     *
     * @param material target material
     * @return true if the material is fence gate
     */
    public static boolean isFenceGate(Material material) {
        if(material == null || !material.isBlock()) return false;
        switch(material) {
            case ACACIA_FENCE_GATE:
            case BIRCH_FENCE_GATE:
            case DARK_OAK_FENCE_GATE:
            case JUNGLE_FENCE_GATE:
            case SPRUCE_FENCE_GATE:
            case OAK_FENCE_GATE:
                return true;
            default:
                return false;
        }
    }

    /**
     * Checks the material is door.
     *
     * @param material target material
     * @return true if the material is door (returns false if it is trapdoor)
     */
    public static boolean isDoor(Material material) {
        if(material == null || !material.isBlock()) return false;
        switch (material) {
            case DARK_OAK_DOOR:
            case ACACIA_DOOR:
            case BIRCH_DOOR:
            case IRON_DOOR:
            case JUNGLE_DOOR:
            case SPRUCE_DOOR:
            case OAK_DOOR:
                return true;
            default:
                return false;
        }
    }

    /**
     * Checks the material is trapdoor.
     *
     * @param material target material
     * @return true if the material is trapdoor (returns false if it is door)
     */
    public static boolean isTrapdoor(Material material) {
        if(material == null || !material.isBlock()) return false;
        switch (material) {
            case ACACIA_TRAPDOOR:
            case BIRCH_TRAPDOOR:
            case IRON_TRAPDOOR:
            case JUNGLE_TRAPDOOR:
            case OAK_TRAPDOOR:
            case DARK_OAK_TRAPDOOR:
            case SPRUCE_TRAPDOOR:
                return true;
            default:
                return false;
        }
    }

    /**
     * Checks the material is glass block.
     *
     * @param material target material
     * @return true if the material is glass
     */
    public static boolean isGlass(Material material) {
        if(material == null || !material.isBlock()) return false;
        if(isThinGlass(material)) return true;
        switch (material) {
            case GLASS:
            case GRAY_STAINED_GLASS:
            case GREEN_STAINED_GLASS:
            case BLACK_STAINED_GLASS:
            case BLUE_STAINED_GLASS:
            case BROWN_STAINED_GLASS:
            case CYAN_STAINED_GLASS:
            case LIGHT_BLUE_STAINED_GLASS:
            case LIGHT_GRAY_STAINED_GLASS:
            case LIME_STAINED_GLASS:
            case MAGENTA_STAINED_GLASS:
            case ORANGE_STAINED_GLASS:
            case PINK_STAINED_GLASS:
            case PURPLE_STAINED_GLASS:
            case RED_STAINED_GLASS:
            case WHITE_STAINED_GLASS:
            case YELLOW_STAINED_GLASS:
                return true;
            default:
                return false;
        }
    }

    /**
     * Checks the material is thin glass.
     *
     * @param material target material
     * @return true if the material is thin glass (including stained glass pane)
     */
    public static boolean isThinGlass(Material material) {
        if(material == null || !material.isBlock()) return false;
        switch (material) {
            case GLASS_PANE:
            case IRON_BARS:
            case BLACK_STAINED_GLASS_PANE:
            case BLUE_STAINED_GLASS_PANE:
            case GRAY_STAINED_GLASS_PANE:
            case GREEN_STAINED_GLASS_PANE:
            case BROWN_STAINED_GLASS_PANE:
            case CYAN_STAINED_GLASS_PANE:
            case LIGHT_BLUE_STAINED_GLASS_PANE:
            case LIGHT_GRAY_STAINED_GLASS_PANE:
            case LIME_STAINED_GLASS_PANE:
            case MAGENTA_STAINED_GLASS_PANE:
            case ORANGE_STAINED_GLASS_PANE:
            case PINK_STAINED_GLASS_PANE:
            case PURPLE_STAINED_GLASS_PANE:
            case RED_STAINED_GLASS_PANE:
            case WHITE_STAINED_GLASS_PANE:
            case YELLOW_STAINED_GLASS_PANE:
                return true;
            default:
                return false;
        }
    }

    /**
     * Checks the material is transparent.
     *
     * @param material target material
     * @return true if the material is transparent
     */
    @SuppressWarnings({ "deprecation" })
    public static boolean isTransparentBlock(Material material) {
        if(material == null || !material.isBlock()) return false;
        if(material.isTransparent() || isGlass(material) || isBanner(material) || isSign(material)) return true;
        switch (material) {
            case BARRIER:
            case FLOWER_POT:
                return true;
            default:
                return false;
        }
    }

    /**
     * Checks the location is in the block
     *
     * @param block the block
     * @param x x coordinates of the location
     * @param y y coordinates of the location
     * @param z z coordinates of the location
     * @return true if the location is in the block
     */
    public static boolean isInBlock(Block block, double x, double y, double z) {
        boolean result = true;
        if(block != null && block.getType() != null) {
            Material type = block.getType();
            int xa = block.getLocation().getBlockX();
            int ya = block.getLocation().getBlockY();
            int za = block.getLocation().getBlockZ();

            double xb = x - xa;
            double yb = y - ya;
            double zb = z - za;

            if(!isTransparent(type)) {
                if (isSlab(type)) {
                    Slab slab = (Slab) block.getBlockData();
                    if (slab.getType() == Slab.Type.TOP && yb >= 0.5) {
                        result = false;
                    } else if (slab.getType() == Slab.Type.BOTTOM && yb <= 0.5) {
                        result = false;
                    } else {
                        result = false;
                    }
                } else if (isStairs(type)) {
                    Stairs stairs = (Stairs) block.getBlockData();
                    if (stairs.getFacing() == BlockFace.EAST && stairs.getHalf() == Bisected.Half.BOTTOM) {
                        if(yb <= 0.5) {
                            result = false;
                        } else if(xb >= 0.5) {
                            result = false;
                        }
                    } else if (stairs.getFacing() == BlockFace.WEST && stairs.getHalf() == Bisected.Half.BOTTOM) {
                        if(yb <= 0.5) {
                            result = false;
                        } else if(xb <= 0.5) {
                            result = false;
                        }
                    } else if (stairs.getFacing() == BlockFace.SOUTH && stairs.getHalf() == Bisected.Half.BOTTOM) {
                        if(yb <= 0.5) {
                            result = false;
                        } else if(zb >= 0.5) {
                            result = false;
                        }
                    } else if (stairs.getFacing() == BlockFace.NORTH && stairs.getHalf() == Bisected.Half.BOTTOM) {
                        if(yb <= 0.5) {
                            result = false;
                        } else if(zb <= 0.5) {
                            result = false;
                        }
                    } else if (stairs.getFacing() == BlockFace.EAST && stairs.getHalf() == Bisected.Half.TOP) {
                        if(yb >= 0.5) {
                            result = false;
                        } else if(xb >= 0.5) {
                            result = false;
                        }
                    } else if (stairs.getFacing() == BlockFace.WEST && stairs.getHalf() == Bisected.Half.TOP) {
                        if(yb >= 0.5) {
                            result = false;
                        } else if(xb <= 0.5) {
                            result = false;
                        }
                    } else if (stairs.getFacing() == BlockFace.SOUTH && stairs.getHalf() == Bisected.Half.TOP) {
                        if(yb >= 0.5) {
                            result = false;
                        } else if(zb >= 0.5) {
                            result = false;
                        }
                    } else if (stairs.getFacing() == BlockFace.NORTH && stairs.getHalf() == Bisected.Half.TOP) {
                        if(yb >= 0.5) {
                            result = false;
                        } else if(zb <= 0.5) {
                            result = false;
                        }
                    }
                } else if(isDoor(type)) {
                    Door door = (Door) block.getBlockData();
                    byte data = 0;
                    if(door.isOpen()) {
                        if(door.getHinge() == Door.Hinge.LEFT) {
                            if(door.getFacing() == BlockFace.EAST) {
                                data = 2;
                            } else if(door.getFacing() == BlockFace.WEST) {
                                data = 3;
                            } else if(door.getFacing() == BlockFace.SOUTH) {
                                data = 1;
                            }
                        } else if(door.getHinge() == Door.Hinge.RIGHT) {
                            if(door.getFacing() == BlockFace.EAST) {
                                data = 3;
                            } else if(door.getFacing() == BlockFace.WEST) {
                                data = 2;
                            } else if(door.getFacing() == BlockFace.NORTH) {
                                data = 1;
                            }
                        }
                    } else {
                        if(door.getFacing() == BlockFace.WEST) {
                            data = 1;
                        } else if(door.getFacing() == BlockFace.SOUTH) {
                            data = 2;
                        } else if(door.getFacing() == BlockFace.NORTH) {
                            data = 3;
                        }
                    }
                    if(data == 0 && xb <= 0.1875) {
                        result = false;
                    } else if(data == 2 && zb <= 0.1875) {
                        result = false;
                    } else if(data == 1 && xb >= 0.8125) {
                        result = false;
                    } else if(data == 3 && zb >= 0.8125) {
                        result = false;
                    }
                } else if(isFence(type)) {
                    World w = block.getLocation().getWorld();
                    Block x0 = w.getBlockAt(xa + 1, ya, za);
                    Block x1 = w.getBlockAt(xa - 1, ya, za);
                    Block z0 = w.getBlockAt(xa, ya, za + 1);
                    Block z1 = w.getBlockAt(xa, ya, za - 1);
                    boolean b = true;
                    if(x0 != null && x0.getType() == block.getType()) {
                        if(xb >= 0.375 && zb >= 0.375 && zb <= 0.625) {
                            b = false;
                        }
                    }
                    if(x1 != null && x1.getType() == block.getType()) {
                        if(xb <= 0.625 && zb >= 0.375 && zb <= 0.625) {
                            b = false;
                        }
                    }
                    if(z0 != null && z0.getType() == block.getType()) {
                        if(zb >= 0.375 && xb >= 0.375 && xb <= 0.625) {
                            b = false;
                        }
                    }
                    if(z1 != null && z1.getType() == block.getType()) {
                        if(zb <= 0.625 && xb >= 0.375 && xb <= 0.625) {
                            b = false;
                        }
                    }
                    result = b;
                } else if(isWall(type)) {
                    World w = block.getLocation().getWorld();
                    Block x0 = w.getBlockAt(xa + 1, ya, za);
                    Block x1 = w.getBlockAt(xa - 1, ya, za);
                    Block z0 = w.getBlockAt(xa, ya, za + 1);
                    Block z1 = w.getBlockAt(xa, ya, za - 1);
                    boolean b = true;
                    if(x0 != null && x0.getType() == block.getType()) {
                        if(xb >= 0.3125 && zb >= 0.3125 && zb <= 0.6875) {
                            b = false;
                        }
                    }
                    if(x1 != null && x1.getType() == block.getType()) {
                        if(xb <= 0.6875 && zb >= 0.3125 && zb <= 0.6875) {
                            b = false;
                        }
                    }
                    if(z0 != null && z0.getType() == block.getType()) {
                        if(zb >= 0.3125 && xb >= 0.3125 && xb <= 0.6875) {
                            b = false;
                        }
                    }
                    if(z1 != null && z1.getType() == block.getType()) {
                        if(zb <= 0.6875 && xb >= 0.3125 && xb <= 0.6875) {
                            b = false;
                        }
                    }
                    result = b;
                } else if(isFenceGate(type)) {
                    Gate gate = (Gate) block.getBlockData();
                    if(!gate.isOpen()) {
                        if ((gate.getFacing() == BlockFace.EAST || gate.getFacing() == BlockFace.WEST) && zb >= 0.375 && zb <= 0.625) {
                            result = false;
                        } else if ((gate.getFacing() == BlockFace.SOUTH || gate.getFacing() == BlockFace.NORTH) && xb >= 0.375 && xb <= 0.625) {
                            result = false;
                        }
                    }
                } else if(isTrapdoor(type)) {
                    TrapDoor door = (TrapDoor) block.getBlockData();
                    byte data = 0;
                    if(door.isOpen()) {
                        if(door.getFacing() == BlockFace.EAST) data = 7;
                        if(door.getFacing() == BlockFace.WEST) data = 6;
                        if(door.getFacing() == BlockFace.SOUTH) data = 5;
                        if(door.getFacing() == BlockFace.NORTH) data = 4;
                    } else {
                        if(door.getHalf() == Bisected.Half.TOP) data = 8;
                    }
                    if(data == 0 && yb <= 0.1875) {
                        result = false;
                    } else if(data == 4 && zb >= 0.8125) {
                        result = false;
                    } else if(data == 5 && zb <= 0.1875) {
                        result = false;
                    } else if(data == 6 && xb >= 0.8125) {
                        result = false;
                    } else if(data == 7 && xb <= 0.1825) {
                        result = false;
                    } else if(data == 8 && yb >= 0.8125) {
                        result = false;
                    }
                } else if(type == Material.END_ROD) {
                    if(xb >= 0.375 && xb <= 0.625 && zb >= 0.375 && zb <= 0.625) {
                        result = false;
                    }
                } else if(type == Material.ENCHANTING_TABLE || type == Material.END_PORTAL_FRAME) {
                    if(yb <= 0.8125) result = false;
                } else {
                    result = false;
                }
            }
        }
        return !result;
    }

}
