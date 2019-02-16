package gg.rsmod.plugins.osrs.content.mechanics.equipment

import gg.rsmod.game.action.EquipAction
import gg.rsmod.plugins.osrs.api.EquipmentType
import gg.rsmod.plugins.osrs.api.ext.playSound
import gg.rsmod.plugins.osrs.api.ext.player
import gg.rsmod.plugins.osrs.api.ext.sendWeaponComponentInformation

val EQUIP_ITEM_SOUND = 2238

fun bind_unequip(equipment: EquipmentType, child: Int) {
    on_button(parent = 387, child = child) {
        val p = it.player()

        val result = EquipAction.unequip(p, equipment.id)
        if (equipment == EquipmentType.WEAPON && result == EquipAction.Result.SUCCESS) {
            p.sendWeaponComponentInformation()
        }
    }
}

for (equipment in EquipmentType.values) {
    on_equip_to_slot(equipment.id) {
        val p = it.player()

        p.playSound(EQUIP_ITEM_SOUND)
        if (equipment == EquipmentType.WEAPON) {
            p.sendWeaponComponentInformation()
        }
    }
}
bind_unequip(EquipmentType.HEAD, child = 6)
bind_unequip(EquipmentType.CAPE, child = 7)
bind_unequip(EquipmentType.AMULET, child = 8)
bind_unequip(EquipmentType.AMMO, child = 16)
bind_unequip(EquipmentType.WEAPON, child = 9)
bind_unequip(EquipmentType.CHEST, child = 10)
bind_unequip(EquipmentType.SHIELD, child = 11)
bind_unequip(EquipmentType.LEGS, child = 12)
bind_unequip(EquipmentType.GLOVES, child = 13)
bind_unequip(EquipmentType.BOOTS, child = 14)

bind_unequip(EquipmentType.RING, child = 15)