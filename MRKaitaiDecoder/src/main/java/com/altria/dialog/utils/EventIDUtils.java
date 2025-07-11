package com.altria.dialog.utils;

import java.util.Map;
import java.util.Set;

import static com.altria.dialog.constant.AppConstant.*;
import static com.altria.dialog.constant.EricssonHeaderConstant.*;
import static com.altria.dialog.constant.HuaweiHeaderConstant.*;

public class EventIDUtils {

    public EventIDUtils() {
    }

    public static final Set<Integer> VALID_EVENT_IDS_HUAWEI_4G = Set.of(
            EVENT_ID_x1001_PUBLIC_INFORMATION,
            EVENT_ID_x1202_PERIOD_INTRA_FREQ_MEASUREMENT,
            EVENT_ID_x1302_PERIOD_INTRA_FREQ_MR_MDT,
            EVENT_ID_x1212_PERIOD_PRIVATE_UE_TA_MDT,
            EVENT_ID_x1211_PERIOD_UE_TA_MR,
            EVENT_ID_x1303_M1_INTER_FREQ_MDT,
            EVENT_ID_x1304_M2_PERIOD_PRIVATE_UE_MEAS_MDT,
            EVENT_ID_x1306_M4_PERIOD_PRIVATE_THROUGHPUT_MDT,
            EVENT_ID_x1307_M5_PERIOD_PRIVATE_THROUGHPUT_MDT,
            EVENT_ID_x1308_RLF_REPORT,
            EVENT_ID_x1309_PERIOD_PRIVATE_CONNEST_FAIL_REPORT,
//            EVENT_ID_x1312_PERIOD_UE_UL_PDCP_DELAY_MDT,
            EVENT_ID_x1314_PERIOD_PRIVATE_PKTLOSS_RATE_MR,
            EVENT_ID_x1321_PERIOD_PRIVATE_UE_MEAS_M2_EXT_MDT,
            EVENT_ID_x1322_PERIOD_PRIVATE_THROUGHPUT_MEAS_M5_EXT_MDT,
            EVENT_ID_x1205_UE_PERIOD_RADIO_LINK_MR,
            EVENT_ID_x100C_RADIO_LINK_FAILURE_REPORT,
            EVENT_ID_x1201_UE_EVENT_MR,
            EVENT_ID_x1203_UE_PERIOD_INTER_FREQ_MR,
            EVENT_ID_x1204_UE_PERIOD_INTER_RAT_MR,
            EVENT_ID_x1206_UE_PERIOD_INTRA_FREQ_MR_MDT,
            EVENT_ID_x1207_UE_PERIOD_INTER_FREQ_MR_MDT,
            EVENT_ID_x1209_UE_PERIOD_RADIO_LINK_MR_MDT
    );

    public static final Map<Integer, String> GET_ID_CHANNEL_MAP_HUAWEI = Map.ofEntries(
            Map.entry(EVENT_ID_x1001_PUBLIC_INFORMATION, HUAWEI_4G_4097),
            Map.entry(EVENT_ID_x1202_PERIOD_INTRA_FREQ_MEASUREMENT, HUAWEI_4G_4610),
            Map.entry(EVENT_ID_x1302_PERIOD_INTRA_FREQ_MR_MDT, HUAWEI_4G_4866),
            Map.entry(EVENT_ID_x1212_PERIOD_PRIVATE_UE_TA_MDT, HUAWEI_4G_4626),
            Map.entry(EVENT_ID_x1211_PERIOD_UE_TA_MR, HUAWEI_4G_4625),
            Map.entry(EVENT_ID_x1303_M1_INTER_FREQ_MDT, HUAWEI_4G_4867),
            Map.entry(EVENT_ID_x1304_M2_PERIOD_PRIVATE_UE_MEAS_MDT, HUAWEI_4G_4868),
            Map.entry(EVENT_ID_x1306_M4_PERIOD_PRIVATE_THROUGHPUT_MDT, HUAWEI_4G_4870),
            Map.entry(EVENT_ID_x1307_M5_PERIOD_PRIVATE_THROUGHPUT_MDT, HUAWEI_4G_4871),
            Map.entry(EVENT_ID_x1308_RLF_REPORT, HUAWEI_4G_4872),
            Map.entry(EVENT_ID_x1309_PERIOD_PRIVATE_CONNEST_FAIL_REPORT, HUAWEI_4G_4873),
//            Map.entry(EVENT_ID_x1312_PERIOD_UE_UL_PDCP_DELAY_MDT, HUAWEI_4G_4882),
            Map.entry(EVENT_ID_x1314_PERIOD_PRIVATE_PKTLOSS_RATE_MR, HUAWEI_4G_4884),
            Map.entry(EVENT_ID_x1321_PERIOD_PRIVATE_UE_MEAS_M2_EXT_MDT, HUAWEI_4G_4897),
            Map.entry(EVENT_ID_x1322_PERIOD_PRIVATE_THROUGHPUT_MEAS_M5_EXT_MDT, HUAWEI_4G_4898),
            Map.entry(EVENT_ID_x1205_UE_PERIOD_RADIO_LINK_MR, HUAWEI_4G_4613),
            Map.entry(EVENT_ID_x100C_RADIO_LINK_FAILURE_REPORT, HUAWEI_4G_4108),
            Map.entry(EVENT_ID_x1201_UE_EVENT_MR, HUAWEI_4G_4609),
            Map.entry(EVENT_ID_x1203_UE_PERIOD_INTER_FREQ_MR, HUAWEI_4G_4611),
            Map.entry(EVENT_ID_x1204_UE_PERIOD_INTER_RAT_MR, HUAWEI_4G_4612),
            Map.entry(EVENT_ID_x1206_UE_PERIOD_INTRA_FREQ_MR_MDT, HUAWEI_4G_4614),
            Map.entry(EVENT_ID_x1207_UE_PERIOD_INTER_FREQ_MR_MDT, HUAWEI_4G_4615),
            Map.entry(EVENT_ID_x1209_UE_PERIOD_RADIO_LINK_MR_MDT, HUAWEI_4G_4617)
    );

    public static final Map<Integer, String> GET_ID_CSV_HEADER_MAP_HUAWEI = Map.ofEntries(
            Map.entry(EVENT_ID_x1001_PUBLIC_INFORMATION, public_info_header_4097),
            Map.entry(EVENT_ID_x1202_PERIOD_INTRA_FREQ_MEASUREMENT, intra_frq_mdt_4610),
            Map.entry(EVENT_ID_x1302_PERIOD_INTRA_FREQ_MR_MDT, intra_freq_mr_mdt_4866),
            Map.entry(EVENT_ID_x1212_PERIOD_PRIVATE_UE_TA_MDT, ta_mdt_4626),
            Map.entry(EVENT_ID_x1211_PERIOD_UE_TA_MR, ta_mr_4625),
            Map.entry(EVENT_ID_x1303_M1_INTER_FREQ_MDT, m1_inter_freq_mdt_4867),
            Map.entry(EVENT_ID_x1304_M2_PERIOD_PRIVATE_UE_MEAS_MDT, m2_period_private_ue_meas_mdt_4868),
            Map.entry(EVENT_ID_x1306_M4_PERIOD_PRIVATE_THROUGHPUT_MDT, m4_period_private_throughput_meas_mdt_4870),
            Map.entry(EVENT_ID_x1307_M5_PERIOD_PRIVATE_THROUGHPUT_MDT, m5_period_private_throughput_meas_mdt_4871),
            Map.entry(EVENT_ID_x1308_RLF_REPORT, rlf_report_4872),
            Map.entry(EVENT_ID_x1309_PERIOD_PRIVATE_CONNEST_FAIL_REPORT, period_private_connest_fail_report_4873),
//            Map.entry(EVENT_ID_x1312_PERIOD_UE_UL_PDCP_DELAY_MDT, periodUeUlpdcpdelayMdt_4882),
            Map.entry(EVENT_ID_x1314_PERIOD_PRIVATE_PKTLOSS_RATE_MR, periodPrivatePktlossrateMr_4884),
            Map.entry(EVENT_ID_x1321_PERIOD_PRIVATE_UE_MEAS_M2_EXT_MDT, periodPrivateUeMeasurementM2extmdt_4897),
            Map.entry(EVENT_ID_x1322_PERIOD_PRIVATE_THROUGHPUT_MEAS_M5_EXT_MDT, periodPrivateThroughputMeasurementM5extmdt_4898),
            Map.entry(EVENT_ID_x1205_UE_PERIOD_RADIO_LINK_MR, uePeriodRadioLinkMr_4613),
            Map.entry(EVENT_ID_x100C_RADIO_LINK_FAILURE_REPORT, radioLinkFailureReport_4108),
            Map.entry(EVENT_ID_x1201_UE_EVENT_MR, ueEventMr_4609),
            Map.entry(EVENT_ID_x1203_UE_PERIOD_INTER_FREQ_MR, uePeriodInterFreqMr_4611),
            Map.entry(EVENT_ID_x1204_UE_PERIOD_INTER_RAT_MR, uePeriodInterRatMr_4612),
            Map.entry(EVENT_ID_x1206_UE_PERIOD_INTRA_FREQ_MR_MDT, uePeriodIntraFreqMrMdt_4614),
            Map.entry(EVENT_ID_x1207_UE_PERIOD_INTER_FREQ_MR_MDT, uePeriodInterFreqMrMdt_4615),
            Map.entry(EVENT_ID_x1209_UE_PERIOD_RADIO_LINK_MR_MDT, uePeriodRadioLinkMrMdt_4617)
    );

    public static final Set<Long> VALID_EVENT_IDS_ERICSSON_5G = Set.of(
            EVENT_5G_ID_3349_CU_CP_PER_UE_PUEM_ENDC_REPORT,
            EVENT_5G_ID_3231_CU_CP_PER_UE_MDT_M6_UL_REPORT,
            EVENT_5G_ID_3230_CU_CP_PER_UE_MDT_REPORT
    );

    public static final Set<Long> VALID_EVENT_IDS_ERICSSON_4G = Set.of(
            EVENT_4G_ID_3112_LOC,
            EVENT_4G_ID_3108_TA,
            EVENT_4G_ID_3115_ERAB,
            EVENT_4G_ID_3116_MDT5,
            EVENT_4G_ID_3114_MDT3,
            EVENT_4G_ID_3076_UE_TRAFFIC,
            EVENT_4G_ID_3075_UE_RADIO_MEAS,
            EVENT_4G_ID_3130_MDT6_DL,
            EVENT_4G_ID_3129_MDT6_UL,
            EVENT_4G_ID_3131_MDT7,
            EVENT_4G_ID_3113_MDT5,
            EVENT_4G_ID_4099_ERAB_SETUP,
            EVENT_4G_ID_4112_PROC_HO_EXEC_X2_OUT,
            EVENT_4G_ID_4110_PROC_HO_PREP_X2_OUT,
            EVENT_4G_ID_4106_PROC_INITIAL_CTXT_SETUP,
            EVENT_4G_ID_4097_PROC_RRC_CONN_SETUP,
            EVENT_4G_ID_4121_PROC_RRC_CONNECTION_RE_ESTABLISHMENT,
            EVENT_4G_ID_4125_PROC_UE_CTXT_RELEASE,
            EVENT_4G_ID_26_RRC_UE_INFORMATION_RESPONSE,
//            EVENT_4G_ID_5269_UE_MEAS_GERAN1,
//            EVENT_4G_ID_5267_UE_MEAS_INTERFREQ1,
            EVENT_4G_ID_5153_UE_MEAS_INTRAFREQ1,
            EVENT_4G_ID_4104_PROC_HO_EXEC_S1_OUT,
            EVENT_4G_ID_5_RRC_RRC_CONNECTION_RELEASE,
            EVENT_4G_ID_8_RRC_RRC_CONNECTION_RECONFIGURATION,
            EVENT_4G_ID_4114_PROC_ERAB_RELEASE
    );

    public static final Map<Long, String> GET_ID_CHANNEL_MAP_ERICSSON_5G = Map.ofEntries(
            Map.entry(EVENT_5G_ID_3349_CU_CP_PER_UE_PUEM_ENDC_REPORT, Ericsson_5G_3349),
            Map.entry(EVENT_5G_ID_3231_CU_CP_PER_UE_MDT_M6_UL_REPORT, Ericsson_5G_3231),
            Map.entry(EVENT_5G_ID_3230_CU_CP_PER_UE_MDT_REPORT, Ericsson_5G_3230)
    );

    public static final Map<Long, String> GET_ID_CHANNEL_MAP_ERICSSON_4G = Map.ofEntries(
            Map.entry(EVENT_4G_ID_3112_LOC, Ericsson_4G_3112),
            Map.entry(EVENT_4G_ID_3108_TA, Ericsson_4G_3108),
            Map.entry(EVENT_4G_ID_3115_ERAB, Ericsson_4G_3115),
            Map.entry(EVENT_4G_ID_3116_MDT5, Ericsson_4G_3116),
            Map.entry(EVENT_4G_ID_3114_MDT3, Ericsson_4G_3114),
            Map.entry(EVENT_4G_ID_3076_UE_TRAFFIC, Ericsson_4G_3076),
            Map.entry(EVENT_4G_ID_3075_UE_RADIO_MEAS, Ericsson_4G_3075),
            Map.entry(EVENT_4G_ID_3130_MDT6_DL, Ericsson_4G_3130),
            Map.entry(EVENT_4G_ID_3129_MDT6_UL, Ericsson_4G_3129),
            Map.entry(EVENT_4G_ID_3131_MDT7, Ericsson_4G_3131),
            Map.entry(EVENT_4G_ID_3113_MDT5, Ericsson_4G_3113),
            Map.entry(EVENT_4G_ID_4099_ERAB_SETUP, Ericsson_4G_4099),
            Map.entry(EVENT_4G_ID_4112_PROC_HO_EXEC_X2_OUT, Ericsson_4G_4112),
            Map.entry(EVENT_4G_ID_4110_PROC_HO_PREP_X2_OUT, Ericsson_4G_4110),
            Map.entry(EVENT_4G_ID_4106_PROC_INITIAL_CTXT_SETUP, Ericsson_4G_4106),
            Map.entry(EVENT_4G_ID_4097_PROC_RRC_CONN_SETUP, Ericsson_4G_4097),
            Map.entry(EVENT_4G_ID_4121_PROC_RRC_CONNECTION_RE_ESTABLISHMENT, Ericsson_4G_4121),
            Map.entry(EVENT_4G_ID_4125_PROC_UE_CTXT_RELEASE, Ericsson_4G_4125),
            Map.entry(EVENT_4G_ID_26_RRC_UE_INFORMATION_RESPONSE, Ericsson_4G_26),
//            Map.entry(EVENT_4G_ID_5269_UE_MEAS_GERAN1, Ericsson_4G_5269),
//            Map.entry(EVENT_4G_ID_5267_UE_MEAS_INTERFREQ1, Ericsson_4G_5267),
            Map.entry(EVENT_4G_ID_5153_UE_MEAS_INTRAFREQ1, Ericsson_4G_5153),
            Map.entry(EVENT_4G_ID_4104_PROC_HO_EXEC_S1_OUT, Ericsson_4G_4104),
            Map.entry(EVENT_4G_ID_5_RRC_RRC_CONNECTION_RELEASE, Ericsson_4G_5),
            Map.entry(EVENT_4G_ID_8_RRC_RRC_CONNECTION_RECONFIGURATION, Ericsson_4G_8),
            Map.entry(EVENT_4G_ID_4114_PROC_ERAB_RELEASE, Ericsson_4G_4114)
    );

    public static final Map<Long, String> GET_ID_CSV_HEADER_MAP_ERICSSON_4G = Map.ofEntries(
            Map.entry(EVENT_4G_ID_3112_LOC, EVENT_HEADER_3112_LOC),
            Map.entry(EVENT_4G_ID_3108_TA, EVENT_HEADER_3108_TA),
            Map.entry(EVENT_4G_ID_3115_ERAB, EVENT_HEADER_3115_ERAB),
            Map.entry(EVENT_4G_ID_3116_MDT5, EVENT_HEADER_3116_MDT5),
            Map.entry(EVENT_4G_ID_3114_MDT3, EVENT_HEADER_3114_MDT3),
            Map.entry(EVENT_4G_ID_3076_UE_TRAFFIC, EVENT_HEADER_3076_UE_TRAFFIC),
            Map.entry(EVENT_4G_ID_3075_UE_RADIO_MEAS, EVENT_HEADER_3075_UE_RADIO_MEAS),
            Map.entry(EVENT_4G_ID_3130_MDT6_DL, EVENT_HEADER_3130_MDT6_DL),
            Map.entry(EVENT_4G_ID_3129_MDT6_UL, EVENT_HEADER_3129_MDT6_UL),
            Map.entry(EVENT_4G_ID_3131_MDT7, EVENT_HEADER_3131_MDT7),
            Map.entry(EVENT_4G_ID_3113_MDT5, EVENT_HEADER_3113_MDT5),
            Map.entry(EVENT_4G_ID_4099_ERAB_SETUP, EVENT_HEADER_4099_ERAB_SETUP),
            Map.entry(EVENT_4G_ID_4112_PROC_HO_EXEC_X2_OUT, EVENT_HEADER_4112_PROC_HO_EXEC_X2_OUT),
            Map.entry(EVENT_4G_ID_4110_PROC_HO_PREP_X2_OUT, EVENT_HEADER_4110_PROC_HO_PREP_X2_OUT),
            Map.entry(EVENT_4G_ID_4106_PROC_INITIAL_CTXT_SETUP, EVENT_HEADER_4106_PROC_INITIAL_CTXT_SETUP),
            Map.entry(EVENT_4G_ID_4097_PROC_RRC_CONN_SETUP, EVENT_HEADER_4097_PROC_RRC_CONN_SETUP),
            Map.entry(EVENT_4G_ID_4121_PROC_RRC_CONNECTION_RE_ESTABLISHMENT, EVENT_HEADER_4121_PROC_RRC_CONNECTION_RE_ESTABLISHMENT),
            Map.entry(EVENT_4G_ID_4125_PROC_UE_CTXT_RELEASE, EVENT_HEADER_4125_PROC_UE_CTXT_RELEASE),
            Map.entry(EVENT_4G_ID_26_RRC_UE_INFORMATION_RESPONSE, EVENT_HEADER_26_RRC_UE_INFORMATION_RESPONSE),
//            Map.entry(EVENT_4G_ID_5269_UE_MEAS_GERAN1, EVENT_HEADER_5269_UE_MEAS_GERAN1),
//            Map.entry(EVENT_4G_ID_5267_UE_MEAS_INTERFREQ1, EVENT_HEADER_5267_UE_MEAS_INTERFREQ1),
            Map.entry(EVENT_4G_ID_5153_UE_MEAS_INTRAFREQ1, EVENT_HEADER_5153_UE_MEAS_INTRAFREQ1),
            Map.entry(EVENT_4G_ID_4104_PROC_HO_EXEC_S1_OUT, EVENT_HEADER_4104_PROC_HO_EXEC_S1_OUT),
            Map.entry(EVENT_4G_ID_5_RRC_RRC_CONNECTION_RELEASE, EVENT_HEADER_5_RRC_RRC_CONNECTION_RELEASE),
            Map.entry(EVENT_4G_ID_8_RRC_RRC_CONNECTION_RECONFIGURATION, EVENT_HEADER_8_RRC_RRC_CONNECTION_RECONFIGURATION),
            Map.entry(EVENT_4G_ID_4114_PROC_ERAB_RELEASE, EVENT_HEADER_4114_PROC_ERAB_RELEASE)
    );

    public static final Map<Long, String> GET_ID_CSV_HEADER_MAP_ERICSSON_5G = Map.ofEntries(
            Map.entry(EVENT_5G_ID_3349_CU_CP_PER_UE_PUEM_ENDC_REPORT, EVENT_HEADER_3349_CU_CP_PER_UE_PUEM_ENDC_REPORT),
            Map.entry(EVENT_5G_ID_3231_CU_CP_PER_UE_MDT_M6_UL_REPORT, EVENT_HEADER_3231_CU_CP_PER_UE_MDT_M6_UL_REPORT),
            Map.entry(EVENT_5G_ID_3230_CU_CP_PER_UE_MDT_REPORT, EVENT_HEADER_3230_CU_CP_PER_UE_MDT_REPORT)
    );


}
