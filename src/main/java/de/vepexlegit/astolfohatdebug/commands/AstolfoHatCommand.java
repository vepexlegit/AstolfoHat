package de.vepexlegit.astolfohatdebug.commands;

import de.vepexlegit.astolfohatdebug.*;
import net.minecraft.command.*;
import net.minecraft.util.*;
import java.util.*;

public class AstolfoHatCommand implements ICommand {
    @Override
    public String getCommandName() {
        return "astolfohat";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return null;
    }

    @Override
    public List<String> getCommandAliases() {
        return Collections.emptyList();
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length != 1 || (!args[0].equalsIgnoreCase("off") && !args[0].equalsIgnoreCase("on"))) {
            sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Invalid Arguments."));
            return;
        }
        AstolfoHat.INSTANCE.setEnabled(args[0].equalsIgnoreCase("on"));
        sender.addChatMessage(new ChatComponentText(String.format(EnumChatFormatting.GREEN + "AstolfoHat has been %s.", AstolfoHat.INSTANCE.isEnabled() ? "Enabled" : EnumChatFormatting.RED + "Disabled")));
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}
