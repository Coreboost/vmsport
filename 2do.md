! CMS REPLACEMENT HISTORY, Element DESCRIP.MMS
! *74   27-OCT-2014 01:55:38 JJO "Add eth_init_udp"
! *73    1-DEC-2013 01:30:04 JJO "Put back lost changes (bt_disconnect)"
! *72    1-DEC-2013 01:24:07 JJO "Add TXGEN_TJL"
! *71   21-NOV-2013 22:23:32 JJO "Change dependencies for bt_disconnect"
! *70   20-NOV-2013 22:26:27 JJO "Add bt_disconnect"
! *69   15-NOV-2013 20:54:42 JJO "Remove old SSL stuff and add bt_send_term_msg"
! *68   14-NOV-2013 16:47:34 JJO "Add bt_add_servers"
! *67   11-NOV-2013 22:57:41 JJO "Fix link of TXGEN_WEB"
! *66    8-JUN-2007 13:08:41 JJO "Modify for new MMS version (.SUFFIXES modified)"
! *65    3-DEC-2006 22:40:14 JJO "Add CLUSTATCOM options file to TVXMAIN link"
! *64    3-DEC-2006 22:14:29 JJO "Add TVX process"
! *63   31-MAR-2006 13:42:02 JJO "Add TXGEN_WEB and TXGEN_COMMON"
! *62   28-MAR-2006 17:55:16 JJO "Remove DB-related processes"
! *61   19-SEP-2003 16:27:10 GULLO "Remove waccs_get_last_trans, add wbets_account_recall"
! *60   12-SEP-2003 13:08:18 JJO "Remove some more FSB and MNB code"
! *59   12-SEP-2003 11:18:51 JJO "Remove obsolete FSB and MNB code"
! *58   11-SEP-2003 14:20:16 JJO "Add TXGEN_ACC"
! *57    4-SEP-2003 15:43:50 AEL "Add TSTAQ programs"
! *56   26-AUG-2003 10:56:02 GULLO "Add aq_acc_inet_status"
! *55   21-AUG-2003 10:48:30 AEL "Add wbets_procBalQuery"
! *54   23-JUL-2003 16:30:15 GULLO "Added AQ transactions"
! *53   22-JUL-2003 10:33:34 GULLO "Add refund transaction"
! *52   30-JUN-2003 12:59:15 AEL "Add AQMAIN process"
! *51   16-APR-2003 17:06:12 JJO "Add tcp_timerAst"
! *50   27-MAR-2003 10:58:25 GULLO "Changed to one return trans from Posten"
! *49   24-MAR-2003 18:12:18 GULLO "Changes for Postens Bankväxel"
! *48   26-NOV-2002 12:59:11 GULLO "Add Waqs_Quick_Appl_Msg.pcx"
! *47    2-OCT-2002 14:18:50 GULLO "Previous Garbo_descrip.mms (Descrip.mms for Oracle 8, JJO's changes in)"
! *46   21-MAY-2002 11:04:14 GULLO "Added Waccs_get_last_trans and Waqs_get_acc_info"
! *45    1-JUN-2001 14:25:41 SCOT "Update for email address handling, FSB and MNB direct deposit handling"
! *44   14-MAY-2001 11:06:07 JJO "Add RRC transaction generator"
! *43   12-MAR-2001 02:45:39 JJO "Change WEB process to use TCP/IP"
! *42    5-MAR-2001 19:32:12 JJO "Move lookup table handling to common code"
! *41   14-FEB-2001 20:46:12 JJO "Change to separate processes for RRC and DM"
! *40   10-FEB-2001 06:30:21 JJO "Add TCP process"
! *39    1-DEC-2000 08:37:19 KAK "Add WINFS_GET_BSDATE"
! *38   27-JAN-2000 04:02:34 JJO "Add more direct deposit functions"
! *37   22-JAN-2000 22:27:26 JJO "Add FSB signing functions"
! *36    8-JAN-1999 13:16:01 AEL "Add waqs_applicationMsg"
! *35    9-OCT-1998 12:58:58 KAK "Add bet_conf_cancel_bet"
! *34   24-AUG-1998 12:45:47 JJO "Add web_timerAst"
! *33   20-MAY-1998 20:18:41 AEL "Fix typo"
! *32   20-MAY-1998 20:15:36 AEL "Add WFE_INACTWARN and WFE_DBLOG_PRINT"
! *31    8-MAY-1998 09:07:44 AEL "Add ArcServer Hello Message"
! *30   21-APR-1998 14:17:33 AEL "Added waccs_cardexpupd and split list request"
! *29   12-JAN-1998 22:45:27 AEL "Added references to AASDEV"
! *28   30-SEP-1997 17:16:33 JJO "Add weod_deposit_fix"
! *27   29-SEP-1997 13:19:43 JJO "Add more WEOD functions"
! *26   26-SEP-1997 17:14:45 JJO "Add web_send_error_msg"
! *25   18-SEP-1997 07:31:03 JJO "Add WEOD process"
! *24   16-SEP-1997 08:14:46 JJO "Add db_access.obj to WFEMAIN dependencies"
! *23   16-SEP-1997 08:05:43 JJO "Add WFEMAIN functions for DB messages"
! *22   19-AUG-1997 11:44:44 JJO "Add wbetr_get_bet, bet_confirm_bet, bet_undo_bet"
! *21   18-AUG-1997 08:55:45 JJO "Add wbetr_lockTerm"
! *20   17-AUG-1997 13:49:41 JJO "Add utl_getEthInfo"
! *19   15-AUG-1997 12:51:25 JJO "Add more dependencies for bet_unlock_term"
! *18   15-AUG-1997 10:53:00 JJO "Add WBETR process"
! *17   10-JUL-1997 07:16:00 JJO "Add WBETS_PROC_FORTUNA"
! *16    9-JUL-1997 08:15:28 JJO "Add UTL_FMT_DATE_TIME"
! *15    8-JUL-1997 00:49:59 JJO "Add WAQS process"
! *14    5-JUN-1997 08:32:28 JJO "Add winfs_getPgmDay"
! *13    3-JUN-1997 14:38:55 JJO "Add wbets_procBet"
! *12   26-MAY-1997 12:48:52 JJO "Change waccs_authUsr to waccs_accLogin"
! *11   23-MAY-1997 17:58:55 JJO "Add wbets_lockTerm and wbets_unlockTerm"
! *10   12-MAY-1997 08:10:08 JJO "Add WACCS"
! *9     4-MAY-1997 19:32:31 JJO "Add wbets_do_signon"
! *8    28-APR-1997 08:37:51 JJO "Add WEB process"
! *7    20-APR-1997 12:44:37 JJO "Fix non-Oracle link to work with object library"
! *6    20-APR-1997 12:32:54 JJO "Add Pro*C++ precompiling and linking"
! *5     6-APR-1997 08:00:23 JJO "Add WINFS process"
! *4     1-APR-1997 09:01:03 JJO "Add more WBETS functions"
! *3    25-MAR-1997 01:01:21 JJO "Add BETDEFS.H to some dependencies"
! *2    24-MAR-1997 06:53:49 JJO "Remove reference to DMERRORS.H (no longer used)"
! *1    24-MAR-1997 06:31:23 JJO "MMS description file for WFE"
! CMS REPLACEMENT HISTORY, Element DESCRIP.MMS
CXXFLAGS = /DEBUG/NOOPTIMIZE/STANDARD=ARM/INCLUDE=SL_DIR
LINK = CXXLINK/DEBUG
OBJECT_LIBRARY = sl_dir:wfe.olb
COM_LIBRARY = com_library_obj:library.olb
CLUSTATCOM_OPT = com_library_src:clustatcom.opt

.SUFFIXES   : .PCX
.MSG.OBJ    : ; MESSAGE /OBJ=$(MMS$TARGET) $(MMS$SOURCE)
.CXX.OBJ    : ; CXX $(CXXFLAGS)/OBJ=$(MMS$TARGET) $(MMS$SOURCE)
.PCX.CXX    : ; PROC iname=$(MMS$SOURCE) oname=$(MMS$TARGET) code=cpp -
		include=(sl_dir:) sys_include=(sl_dir:) -
		mode=ansi sqlcheck=semantics -
		userid=wfesys/wfesys
.MSG.OBJ    : ; MESSAGE /OBJ=$(MMS$TARGET) $(MMS$SOURCE)

ALL : -
	sl_dir:wfemain.exe,-
	sl_dir:ethmain.exe,-
	sl_dir:tvxmain.exe,-
	sl_dir:btmain.exe,-
	sl_dir:rrcmain.exe,-
	sl_dir:webmain.exe,-
	sl_dir:txgen.exe,-
	sl_dir:txgen_acc.exe,-
	sl_dir:txgen_rrc.exe,-
	sl_dir:txgen_tjl.exe,-
	sl_dir:txgen_web.exe
	@ continue

!
!  WFE Main process
!
SL_DIR:WFEMAIN.EXE : -
 	sl_dir:wfemain.obj,-
	$(object_library)(sl_dir:wfe_map_sect.obj),-
	$(object_library)(sl_dir:wfe_start_procs.obj),-
	$(object_library)(sl_dir:wfe_proc_term.obj),-
	$(object_library)(sl_dir:wfe_check_quotas.obj),-
	$(object_library)(sl_dir:wfe_init_proc_info.obj),-
 	$(object_library)(sl_dir:globalmem.obj),-
 	$(object_library)(sl_dir:msgproc.obj),-
	$(object_library)(sl_dir:utl_read_config.obj),-
 	$(object_library)(sl_dir:utl_event_log.obj),-
        $(object_library)(sl_dir:wfe_message.obj)
	$(LINK) /EXE=$(MMS$TARGET) sl_dir:wfemain.obj,$(OBJECT_LIBRARY)/LIBRARY
	 @SL_DIR:SET_EXE $(MMS$TARGET)/NODEBUG

!
! ETH process
!
SL_DIR:ETHMAIN.EXE : -
 	sl_dir:ethmain.obj,-
 	$(object_library)(sl_dir:eth_init.obj),-
 	$(object_library)(sl_dir:eth_init_udp.obj),-
 	$(object_library)(sl_dir:eth_send_start_msg.obj),-
 	$(object_library)(sl_dir:eth_proc_tbl_upd.obj),-
 	$(object_library)(sl_dir:eth_send_int_msg.obj),-
	$(object_library)(sl_dir:eth_init_wrbuf.obj),-
	$(object_library)(sl_dir:eth_flush_wrbuf.obj),-
	$(object_library)(sl_dir:eth_send_msg.obj),-
	$(object_library)(sl_dir:eth_start_timer.obj),-
 	$(object_library)(sl_dir:eth_read_ast.obj),-
 	$(object_library)(sl_dir:eth_send_statistics.obj),-
 	$(object_library)(sl_dir:eth_write_ast.obj),-
 	$(object_library)(sl_dir:ethhello.obj),-
 	$(object_library)(sl_dir:globalmem.obj),-
 	$(object_library)(sl_dir:msgproc.obj),-
	$(object_library)(sl_dir:utl_get_eth_info.obj),-
	$(object_library)(sl_dir:utl_read_config.obj),-
 	$(object_library)(sl_dir:utl_event_log.obj),-
        $(object_library)(sl_dir:wfe_message.obj)
	$(LINK) /EXE=$(MMS$TARGET) sl_dir:ethmain.obj,$(OBJECT_LIBRARY)/LIBRARY
	 @SL_DIR:SET_EXE $(MMS$TARGET)/NODEBUG

!
! TVX process
!
SL_DIR:TVXMAIN.EXE : -
 	sl_dir:tvxmain.obj,-
 	$(object_library)(sl_dir:globalmem.obj),-
 	$(object_library)(sl_dir:msgproc.obj),-
	$(object_library)(sl_dir:utl_get_eth_info.obj),-
	$(object_library)(sl_dir:utl_read_config.obj),-
 	$(object_library)(sl_dir:utl_event_log.obj),-
        $(object_library)(sl_dir:wfe_message.obj),-
        $(com_library),-
        $(clustatcom_opt)
	$(LINK) /EXE=$(MMS$TARGET) -
sl_dir:tvxmain.obj,-
$(OBJECT_LIBRARY)/LIBRARY,-
$(COM_LIBRARY)/LIBRARY,-
$(CLUSTATCOM_OPT)/OPTION
	 @SL_DIR:SET_EXE $(MMS$TARGET)/NODEBUG

!
!  BT process
!
SL_DIR:BTMAIN.EXE : -
 	sl_dir:btmain.obj,-
        $(object_library)(sl_dir:bt_accept_ast.obj),-
        $(object_library)(sl_dir:bt_add_servers.obj),-
        $(object_library)(sl_dir:bt_disconnect.obj),-
        $(object_library)(sl_dir:bt_proc_x25_msg.obj),-
        $(object_library)(sl_dir:bt_read_lcw_file.obj),-
 	$(object_library)(sl_dir:bt_read_ast.obj),-
        $(object_library)(sl_dir:bt_read_profile.obj),-
 	$(object_library)(sl_dir:bt_send_term_error_msg.obj),-
 	$(object_library)(sl_dir:bt_send_term_msg.obj),-
 	$(object_library)(sl_dir:tcptbls.obj),-
 	$(object_library)(sl_dir:tcp_disconnect.obj),-
        $(object_library)(sl_dir:tcp_fmt_be_msg.obj),-
        $(object_library)(sl_dir:tcp_fmt_dm_msg.obj),-
 	$(object_library)(sl_dir:tcp_init.obj),-
 	$(object_library)(sl_dir:tcp_listen.obj),-
 	$(object_library)(sl_dir:tcp_read.obj),-
 	$(object_library)(sl_dir:tcp_send_term_msg.obj),-
 	$(object_library)(sl_dir:tcp_timer_ast.obj),-
 	$(object_library)(sl_dir:tcp_write.obj),-
 	$(object_library)(sl_dir:tcp_write_ast.obj),-
 	$(object_library)(sl_dir:globalmem.obj),-
 	$(object_library)(sl_dir:msgproc.obj),-
	$(object_library)(sl_dir:utl_read_config.obj),-
 	$(object_library)(sl_dir:utl_event_log.obj),-
 	$(object_library)(sl_dir:utl_conv_ip_bin_char.obj),-
 	$(object_library)(sl_dir:utl_conv_ip_char_bin.obj),-
        $(object_library)(sl_dir:wfe_message.obj)
	$(LINK) /EXE=$(MMS$TARGET) sl_dir:btmain.obj,$(OBJECT_LIBRARY)/LIBRARY
	 @SL_DIR:SET_EXE $(MMS$TARGET)/NODEBUG

!
!  RRC process
!
SL_DIR:RRCMAIN.EXE : -
 	sl_dir:rrcmain.obj,-
        $(object_library)(sl_dir:rrc_accept_ast.obj),-
        $(object_library)(sl_dir:rrc_proc_x25_msg.obj),-
 	$(object_library)(sl_dir:rrc_read_ast.obj),-
 	$(object_library)(sl_dir:tcp_disconnect.obj),-
        $(object_library)(sl_dir:tcp_fmt_be_msg.obj),-
        $(object_library)(sl_dir:tcp_fmt_dm_msg.obj),-
 	$(object_library)(sl_dir:tcp_init.obj),-
 	$(object_library)(sl_dir:tcp_listen.obj),-
 	$(object_library)(sl_dir:tcp_read.obj),-
 	$(object_library)(sl_dir:tcp_send_term_msg.obj),-
 	$(object_library)(sl_dir:tcp_write.obj),-
 	$(object_library)(sl_dir:tcp_write_ast.obj),-
 	$(object_library)(sl_dir:globalmem.obj),-
 	$(object_library)(sl_dir:msgproc.obj),-
	$(object_library)(sl_dir:utl_read_config.obj),-
 	$(object_library)(sl_dir:utl_event_log.obj),-
 	$(object_library)(sl_dir:utl_conv_ip_bin_char.obj),-
 	$(object_library)(sl_dir:utl_conv_ip_char_bin.obj),-
        $(object_library)(sl_dir:wfe_message.obj)
	$(LINK) /EXE=$(MMS$TARGET) sl_dir:rrcmain.obj,$(OBJECT_LIBRARY)/LIBRARY
	 @SL_DIR:SET_EXE $(MMS$TARGET)/NODEBUG

!
!  WEB process
!
SL_DIR:WEBMAIN.EXE : -
 	sl_dir:webmain.obj,-
 	$(object_library)(sl_dir:web_accept_ast.obj),-
 	$(object_library)(sl_dir:web_init.obj),-
 	$(object_library)(sl_dir:web_read_ast.obj),-
 	$(object_library)(sl_dir:tcptbls.obj),-
 	$(object_library)(sl_dir:tcp_disconnect.obj),-
        $(object_library)(sl_dir:tcp_fmt_be_msg.obj),-
        $(object_library)(sl_dir:tcp_fmt_dm_msg.obj),-
 	$(object_library)(sl_dir:tcp_init.obj),-
 	$(object_library)(sl_dir:tcp_listen.obj),-
 	$(object_library)(sl_dir:tcp_read.obj),-
 	$(object_library)(sl_dir:tcp_send_term_msg.obj),-
 	$(object_library)(sl_dir:tcp_write.obj),-
 	$(object_library)(sl_dir:tcp_write_ast.obj),-
 	$(object_library)(sl_dir:globalmem.obj),-
 	$(object_library)(sl_dir:msgproc.obj),-
 	$(object_library)(sl_dir:utl_conv_ip_bin_char.obj),-
 	$(object_library)(sl_dir:utl_conv_ip_char_bin.obj),-
 	$(object_library)(sl_dir:utl_event_log.obj),-
	$(object_library)(sl_dir:utl_read_config.obj),-
        $(object_library)(sl_dir:wfe_message.obj)
	$(LINK) /EXE=$(MMS$TARGET) sl_dir:webmain.obj,$(OBJECT_LIBRARY)/LIBRARY
	 @SL_DIR:SET_EXE $(MMS$TARGET)/NODEBUG

!
!  Transaction simulators
!
SL_DIR:TXGEN.EXE : -
 	sl_dir:txgen.obj,-
 	$(object_library)(sl_dir:utl_conv_ip_char_bin.obj),-
 	$(object_library)(sl_dir:utl_event_log.obj),-
	$(object_library)(sl_dir:utl_read_config.obj),-
 	$(object_library)(sl_dir:txgen_common.obj),-
        $(object_library)(sl_dir:wfe_message.obj)
	$(LINK) /EXE=$(MMS$TARGET) sl_dir:txgen.obj,$(OBJECT_LIBRARY)/LIBRARY
	 @SL_DIR:SET_EXE $(MMS$TARGET)/NODEBUG

SL_DIR:TXGEN_ACC.EXE : -
 	sl_dir:txgen_acc.obj,-
 	$(object_library)(sl_dir:utl_conv_ip_char_bin.obj),-
 	$(object_library)(sl_dir:utl_event_log.obj),-
	$(object_library)(sl_dir:utl_read_config.obj),-
 	$(object_library)(sl_dir:txgen_common.obj),-
        $(object_library)(sl_dir:wfe_message.obj)
	$(LINK) /EXE=$(MMS$TARGET) sl_dir:txgen_acc.obj,$(OBJECT_LIBRARY)/LIBRARY
	 @SL_DIR:SET_EXE $(MMS$TARGET)/NODEBUG

SL_DIR:TXGEN_RRC.EXE : -
 	sl_dir:txgen_rrc.obj,-
 	$(object_library)(sl_dir:utl_conv_ip_char_bin.obj),-
 	$(object_library)(sl_dir:utl_event_log.obj),-
	$(object_library)(sl_dir:utl_read_config.obj),-
 	$(object_library)(sl_dir:txgen_common.obj),-
        $(object_library)(sl_dir:wfe_message.obj)
	$(LINK) /EXE=$(MMS$TARGET) sl_dir:txgen_rrc.obj,$(OBJECT_LIBRARY)/LIBRARY
	 @SL_DIR:SET_EXE $(MMS$TARGET)/NODEBUG

SL_DIR:TXGEN_TJL.EXE : -
 	sl_dir:txgen_tjl.obj,-
 	$(object_library)(sl_dir:utl_conv_ip_char_bin.obj),-
 	$(object_library)(sl_dir:utl_event_log.obj),-
	$(object_library)(sl_dir:utl_read_config.obj),-
 	$(object_library)(sl_dir:txgen_common.obj),-
        $(object_library)(sl_dir:wfe_message.obj)
	$(LINK) /EXE=$(MMS$TARGET) sl_dir:txgen_tjl.obj,$(OBJECT_LIBRARY)/LIBRARY
	 @SL_DIR:SET_EXE $(MMS$TARGET)/NODEBUG

SL_DIR:TXGEN_WEB.EXE : -
 	sl_dir:txgen_web.obj,-
 	$(object_library)(sl_dir:utl_conv_ip_char_bin.obj),-
 	$(object_library)(sl_dir:utl_event_log.obj),-
	$(object_library)(sl_dir:utl_read_config.obj),-
 	$(object_library)(sl_dir:txgen_common.obj),-
        $(object_library)(sl_dir:wfe_message.obj)
	$(LINK) /EXE=$(MMS$TARGET) sl_dir:txgen_web.obj,$(OBJECT_LIBRARY)/LIBRARY
	 @SL_DIR:SET_EXE $(MMS$TARGET)/NODEBUG

!
! Object library
!
$(object_library) : -
	$(object_library)(sl_dir:wfe_map_sect.obj),-
	$(object_library)(sl_dir:wfe_start_procs.obj),-
	$(object_library)(sl_dir:wfe_proc_term.obj),-
	$(object_library)(sl_dir:wfe_check_quotas.obj),-
 	$(object_library)(sl_dir:eth_init.obj),-
 	$(object_library)(sl_dir:eth_init_udp.obj),-
 	$(object_library)(sl_dir:eth_send_start_msg.obj),-
 	$(object_library)(sl_dir:eth_proc_tbl_upd.obj),-
 	$(object_library)(sl_dir:eth_send_int_msg.obj),-
	$(object_library)(sl_dir:eth_init_wrbuf.obj),-
	$(object_library)(sl_dir:eth_flush_wrbuf.obj),-
	$(object_library)(sl_dir:eth_send_msg.obj),-
	$(object_library)(sl_dir:eth_start_timer.obj),-
 	$(object_library)(sl_dir:eth_read_ast.obj),-
 	$(object_library)(sl_dir:eth_send_statistics.obj),-
 	$(object_library)(sl_dir:eth_write_ast.obj),-
 	$(object_library)(sl_dir:ethhello.obj),-
        $(object_library)(sl_dir:bt_accept_ast.obj),-
        $(object_library)(sl_dir:bt_add_servers.obj),-
        $(object_library)(sl_dir:bt_disconnect.obj),-
        $(object_library)(sl_dir:bt_proc_x25_msg.obj),-
        $(object_library)(sl_dir:bt_read_lcw_file.obj),-
        $(object_library)(sl_dir:bt_read_profile.obj),-
 	$(object_library)(sl_dir:bt_send_term_error_msg.obj),-
 	$(object_library)(sl_dir:bt_send_term_msg.obj),-
        $(object_library)(sl_dir:rrc_accept_ast.obj),-
        $(object_library)(sl_dir:rrc_proc_x25_msg.obj),-
 	$(object_library)(sl_dir:tcptbls.obj),-
 	$(object_library)(sl_dir:tcp_disconnect.obj),-
        $(object_library)(sl_dir:tcp_fmt_be_msg.obj),-
        $(object_library)(sl_dir:tcp_fmt_dm_msg.obj),-
 	$(object_library)(sl_dir:tcp_init.obj),-
 	$(object_library)(sl_dir:tcp_listen.obj),-
 	$(object_library)(sl_dir:tcp_read.obj),-
 	$(object_library)(sl_dir:tcp_send_term_msg.obj),-
 	$(object_library)(sl_dir:tcp_timer_ast.obj),-
 	$(object_library)(sl_dir:tcp_write.obj),-
 	$(object_library)(sl_dir:tcp_write_ast.obj),-
 	$(object_library)(sl_dir:txgen_common.obj),-
 	$(object_library)(sl_dir:web_accept_ast.obj),-
 	$(object_library)(sl_dir:web_init.obj),-
 	$(object_library)(sl_dir:globalmem.obj),-
 	$(object_library)(sl_dir:msgproc.obj),-
 	$(object_library)(sl_dir:utl_conv_ip_bin_char.obj),-
 	$(object_library)(sl_dir:utl_conv_ip_char_bin.obj),-
 	$(object_library)(sl_dir:utl_event_log.obj),-
	$(object_library)(sl_dir:utl_read_config.obj),-
        $(object_library)(sl_dir:wfe_message.obj)
	@ continue

!
! Object files
!
SL_DIR:WFEMAIN.OBJ : -
	sl_dir:wfemain.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:globaldef.h,-
	sl_dir:evl.h,-
	sl_dir:msgdefs.h,-
	sl_dir:wfemaindefs.h,-
	sl_dir:wfeglobals.h

SL_DIR:WFE_MAP_SECT.OBJ : -
	sl_dir:wfe_map_sect.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:evl.h,-
	sl_dir:msgdefs.h,-
	sl_dir:wfemaindefs.h,-
	sl_dir:wfeglobals.h

SL_DIR:WFE_START_PROCS.OBJ : -
	sl_dir:wfe_start_procs.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:msgdefs.h,-
	sl_dir:wfemaindefs.h,-
	sl_dir:wfeglobals.h

SL_DIR:WFE_PROC_TERM.OBJ : -
	sl_dir:wfe_proc_term.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:evl.h,-
	sl_dir:msgdefs.h,-
	sl_dir:wfemaindefs.h,-
	sl_dir:wfeglobals.h

SL_DIR:WFE_CHECK_QUOTAS.OBJ : -
	sl_dir:wfe_check_quotas.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:evl.h,-
	sl_dir:msgdefs.h,-
	sl_dir:wfemaindefs.h,-
	sl_dir:wfeglobals.h

SL_DIR:WFE_INIT_PROC_INFO.OBJ : -
	sl_dir:wfe_init_proc_info.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:msgdefs.h,-
	sl_dir:wfemaindefs.h,-
	sl_dir:wfeglobals.h

SL_DIR:ETHMAIN.OBJ : -
	sl_dir:ethmain.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:msgdefs.h,-
	sl_dir:evl.h,-
	sl_dir:ethdefs.h,-
	sl_dir:globaldef.h,-
	sl_dir:ethglobals.h
 
SL_DIR:ETH_PROC_TBL_UPD.OBJ : -
	sl_dir:eth_proc_tbl_upd.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:evl.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:msgdefs.h,-
	sl_dir:ethdefs.h,-
	sl_dir:ethglobals.h

SL_DIR:ETH_SEND_START_MSG.OBJ : -
	sl_dir:eth_send_start_msg.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:evl.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:msgdefs.h,-
	sl_dir:ethdefs.h,-
	sl_dir:ethglobals.h

SL_DIR:ETH_SEND_INT_MSG.OBJ : -
	sl_dir:eth_send_int_msg.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:evl.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:msgdefs.h,-
	sl_dir:ethdefs.h,-
	sl_dir:ethglobals.h

SL_DIR:ETHHELLO.OBJ : -
	sl_dir:ethhello.cxx,-
	sl_dir:globalref.h,-
	sl_dir:nmadef.h,-
	sl_dir:wfedefs.h,-
	sl_dir:evl.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:msgdefs.h,-
	sl_dir:ethdefs.h,-
	sl_dir:ethglobals.h

SL_DIR:ETH_INIT.OBJ : -
	sl_dir:eth_init.cxx,-
	sl_dir:nmadef.h,-
	sl_dir:wfedefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:msgdefs.h,-
	sl_dir:ethdefs.h,-
	sl_dir:ethglobals.h

SL_DIR:ETH_INIT_UDP.OBJ : -
	sl_dir:eth_init_udp.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:msgdefs.h,-
	sl_dir:ethdefs.h,-
	sl_dir:ethglobals.h

SL_DIR:ETH_FLUSH_WRBUF.OBJ : -
	sl_dir:eth_flush_wrbuf.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:evl.h,-
	sl_dir:gmfixed.h,-
	sl_dir:msgdefs.h,-
	sl_dir:ethdefs.h,-
	sl_dir:ethglobals.h

SL_DIR:ETH_INIT_WRBUF.OBJ : -
	sl_dir:eth_init_wrbuf.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:evl.h,-
	sl_dir:gmfixed.h,-
	sl_dir:msgdefs.h,-
	sl_dir:ethdefs.h,-
	sl_dir:ethglobals.h

SL_DIR:ETH_SEND_MSG.OBJ : -
	sl_dir:eth_send_msg.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:evl.h,-
	sl_dir:gmfixed.h,-
	sl_dir:msgdefs.h,-
	sl_dir:ethdefs.h,-
	sl_dir:ethglobals.h

SL_DIR:ETH_START_TIMER.OBJ : -
	sl_dir:eth_start_timer.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:evl.h,-
	sl_dir:gmfixed.h,-
	sl_dir:msgdefs.h,-
	sl_dir:ethdefs.h,-
	sl_dir:ethglobals.h

SL_DIR:ETH_READ_AST.OBJ : -
	sl_dir:eth_read_ast.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:evl.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:msgdefs.h,-
	sl_dir:ethdefs.h,-
	sl_dir:ethglobals.h

SL_DIR:ETH_SEND_STATISTICS.OBJ : -
 	sl_dir:eth_send_statistics.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:msgdefs.h,-
	sl_dir:ethdefs.h,-
	sl_dir:ethglobals.h

SL_DIR:ETH_WRITE_AST.OBJ : -
	sl_dir:eth_write_ast.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:evl.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:msgdefs.h,-
	sl_dir:ethdefs.h,-
	sl_dir:ethglobals.h

SL_DIR:TVXMAIN.OBJ : -
	sl_dir:tvxmain.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:msgdefs.h,-
	sl_dir:evl.h,-
	sl_dir:mboxdefs.h,-
	sl_dir:dmerrors.h
 
SL_DIR:BTMAIN.OBJ : -
	sl_dir:btmain.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:evl.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:globaldef.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h,-
	sl_dir:btdefs.h,-
	sl_dir:btglobals.h

SL_DIR:BT_ACCEPT_AST.OBJ : -
	sl_dir:bt_accept_ast.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h,-
	sl_dir:btdefs.h,-
	sl_dir:btglobals.h

SL_DIR:BT_ADD_SERVERS.OBJ : -
	sl_dir:bt_add_servers.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h,-
	sl_dir:btdefs.h,-
	sl_dir:btglobals.h

SL_DIR:BT_DISCONNECT.OBJ : -
	sl_dir:bt_disconnect.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h,-
	sl_dir:btdefs.h

SL_DIR:BT_READ_LCW_FILE.OBJ : -
	sl_dir:bt_read_lcw_file.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h,-
	sl_dir:btdefs.h,-
	sl_dir:btglobals.h

SL_DIR:BT_READ_PROFILE.OBJ : -
	sl_dir:bt_read_profile.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h,-
	sl_dir:btdefs.h,-
	sl_dir:btglobals.h

SL_DIR:BT_PROC_X25_MSG.OBJ : -
	sl_dir:bt_proc_x25_msg.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h,-
	sl_dir:btdefs.h,-
	sl_dir:btglobals.h

SL_DIR:BT_READ_AST.OBJ : -
	sl_dir:bt_read_ast.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h,-
	sl_dir:btdefs.h,-
	sl_dir:btglobals.h,-
	sl_dir:dmerrors.h

SL_DIR:BT_SEND_TERM_ERROR_MSG.OBJ : -
	sl_dir:bt_send_term_error_msg.cxx,-
	sl_dir:msgdefs.h,-
	sl_dir:evl.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h
 
SL_DIR:BT_SEND_TERM_MSG.OBJ : -
	sl_dir:bt_send_term_msg.cxx,-
	sl_dir:msgdefs.h,-
	sl_dir:evl.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h
 
SL_DIR:RRCMAIN.OBJ : -
	sl_dir:rrcmain.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:evl.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:globaldef.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h,-
	sl_dir:rrcglobals.h

SL_DIR:RRC_ACCEPT_AST.OBJ : -
	sl_dir:rrc_accept_ast.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h,-
	sl_dir:rrcglobals.h

SL_DIR:RRC_PROC_X25_MSG.OBJ : -
	sl_dir:rrc_proc_x25_msg.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h,-
	sl_dir:rrcglobals.h

SL_DIR:RRC_READ_AST.OBJ : -
	sl_dir:rrc_read_ast.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h,-
	sl_dir:dmerrors.h

SL_DIR:TCPTBLS.OBJ : -
	sl_dir:tcptbls.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h,-
	sl_dir:btdefs.h,-
	sl_dir:btglobals.h

SL_DIR:TCP_DISCONNECT.OBJ : -
	sl_dir:tcp_disconnect.cxx,-
	sl_dir:ucxdefs.h,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h

SL_DIR:TCP_FMT_BE_MSG.OBJ : -
	sl_dir:tcp_fmt_be_msg.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h

SL_DIR:TCP_FMT_DM_MSG.OBJ : -
	sl_dir:tcp_fmt_dm_msg.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h

SL_DIR:TCP_INIT.OBJ : -
	sl_dir:tcp_init.cxx,-
	sl_dir:ucxdefs.h,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h

SL_DIR:TCP_LISTEN.OBJ : -
	sl_dir:tcp_listen.cxx,-
	sl_dir:ucxdefs.h,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h

SL_DIR:TCP_READ.OBJ : -
	sl_dir:tcp_read.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:evl.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h

SL_DIR:TCP_SEND_TERM_MSG.OBJ : -
	sl_dir:tcp_send_term_msg.cxx,-
	sl_dir:msgdefs.h,-
	sl_dir:evl.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h
 
SL_DIR:TCP_TIMER_AST.OBJ : -
	sl_dir:tcp_timer_ast.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:evl.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h

SL_DIR:TCP_WRITE.OBJ : -
	sl_dir:tcp_write.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:evl.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h

SL_DIR:TCP_WRITE_AST.OBJ : -
	sl_dir:tcp_write_ast.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h

SL_DIR:WEBMAIN.OBJ : -
	sl_dir:webmain.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:evl.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:globaldef.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h,-
	sl_dir:webglobals.h

SL_DIR:WEB_ACCEPT_AST.OBJ : -
	sl_dir:web_accept_ast.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h,-
	sl_dir:webglobals.h

SL_DIR:WEB_READ_AST.OBJ : -
	sl_dir:web_read_ast.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h,-
	sl_dir:webglobals.h

SL_DIR:WEB_INIT.OBJ : -
	sl_dir:web_init.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h,-
	sl_dir:webglobals.h

SL_DIR:GLOBALMEM.OBJ : -
 	sl_dir:globalmem.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:evl.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:globaldef.h

SL_DIR:MSGPROC.OBJ : -
	sl_dir:msgproc.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:gmdefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:globaldef.h

SL_DIR:UTL_CONV_IP_BIN_CHAR.OBJ : -
 	sl_dir:utl_conv_ip_bin_char.cxx,-
	sl_dir:wfedefs.h

SL_DIR:UTL_CONV_IP_CHAR_BIN.OBJ : -
 	sl_dir:utl_conv_ip_char_bin.cxx,-
	sl_dir:wfedefs.h

SL_DIR:UTL_GET_ETH_INFO.OBJ : -
	sl_dir:utl_get_eth_info.cxx,-
	sl_dir:nmadef.h,-
	sl_dir:wfedefs.h 

SL_DIR:UTL_READ_CONFIG.OBJ : -
	sl_dir:utl_read_config.cxx,-
	sl_dir:evl.h,-
	sl_dir:wfedefs.h 

SL_DIR:UTL_EVENT_LOG.OBJ : -
 	sl_dir:utl_event_log.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:evl.h 

SL_DIR:WFE_DBLOG_PRINT.OBJ : -
	sl_dir:wfe_dblog_print.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:evl.h

SL_DIR:WFE_INACTWARN.OBJ : -
	sl_dir:wfe_inactwarn.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:evl.h

SL_DIR:TXGEN.OBJ : -
	sl_dir:txgen.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:globaldef.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h,-
	sl_dir:txgen_defs.h,-
	sl_dir:txgen_globals.h,-
	sl_dir:btdefs.h,-
	sl_dir:ucxdefs.h

SL_DIR:TXGEN_ACC.OBJ : -
	sl_dir:txgen_acc.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:globaldef.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h,-
	sl_dir:txgen_defs.h,-
	sl_dir:txgen_globals.h,-
	sl_dir:btdefs.h,-
	sl_dir:ucxdefs.h

SL_DIR:TXGEN_RRC.OBJ : -
	sl_dir:txgen_rrc.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:globaldef.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h,-
	sl_dir:txgen_defs.h,-
	sl_dir:txgen_globals.h,-
	sl_dir:btdefs.h,-
	sl_dir:ucxdefs.h

SL_DIR:TXGEN_WEB.OBJ : -
	sl_dir:txgen_web.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:globaldef.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h,-
	sl_dir:txgen_defs.h,-
	sl_dir:txgen_globals.h,-
	sl_dir:btdefs.h,-
	sl_dir:ucxdefs.h

SL_DIR:TXGEN_COMMON.OBJ : -
	sl_dir:txgen_common.cxx,-
	sl_dir:wfedefs.h,-
	sl_dir:msgdefs.h,-
	sl_dir:gmfixed.h,-
	sl_dir:tcpdefs.h,-
	sl_dir:tcpglobals.h,-
	sl_dir:txgen_defs.h,-
	sl_dir:txgen_globals.h,-
	sl_dir:btdefs.h,-
	sl_dir:ucxdefs.h

!
! Message file
!--------------

SL_DIR:WFE_MESSAGE.OBJ : -
    sl_dir:wfe_message.msg

!
! Miscellaneous
!--------------

CLEAN	:
	purge/keep=3
	delete/nolog *.obj;*,wfe.olb;*,*.exe;*
