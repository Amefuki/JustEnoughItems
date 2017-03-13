package mezz.jei.plugins.jei.ingredients;

import javax.annotation.Nullable;
import java.awt.Color;
import java.util.Collections;
import java.util.List;

import mezz.jei.api.ingredients.IIngredientHelper;
import mezz.jei.config.Constants;
import mezz.jei.util.CommandUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

public class DebugIngredientHelper implements IIngredientHelper<DebugIngredient> {
	@Override
	public List<DebugIngredient> expandSubtypes(List<DebugIngredient> ingredients) {
		return ingredients;
	}

	@Nullable
	@Override
	public DebugIngredient getMatch(Iterable<DebugIngredient> ingredients, DebugIngredient ingredientToMatch) {
		for (DebugIngredient debugIngredient : ingredients) {
			if (debugIngredient.getNumber() == ingredientToMatch.getNumber()) {
				return debugIngredient;
			}
		}
		return null;
	}

	@Override
	public String getDisplayName(DebugIngredient ingredient) {
		return "JEI Debug Item #" + ingredient.getNumber();
	}

	@Override
	public String getUniqueId(DebugIngredient ingredient) {
		return "JEI_debug_" + ingredient.getNumber();
	}

	@Override
	public String getWildcardId(DebugIngredient ingredient) {
		return getUniqueId(ingredient);
	}

	@Override
	public String getModId(DebugIngredient ingredient) {
		return Constants.MOD_ID;
	}

	@Override
	public Iterable<Color> getColors(DebugIngredient ingredient) {
		return Collections.emptyList();
	}

	@Override
	public ItemStack cheatIngredient(DebugIngredient ingredient, boolean fullStack) {
		CommandUtil.writeChatMessage(Minecraft.getMinecraft().player, "Debug ingredients cannot be cheated", TextFormatting.RED);
		return ItemStack.EMPTY;
	}

	@Override
	public String getErrorInfo(DebugIngredient ingredient) {
		return getDisplayName(ingredient);
	}
}
