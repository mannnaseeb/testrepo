package com.loyaltyservice.constant;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import lombok.Getter;

@Getter
public enum ResponseStatusCodes {
	 INVALID_PROJECT_FORMAT("60417"),INVALID_MAPPING("60308"),INVALID_PROJECT_UUID("60009"), PHASE_NAME_IS_MANDATORY("60010"),PHASE_NAME_IS_INVALID("60011"),INVALID_PROJECT_DESCRIPTION("60417"),

	 PHASE_NAME_IS_NOT_VALID("60012"), PHASE_NAME_MAX_LENGTH("60013"),
	BLANK_PROJECT_NAME("60433"),BLANK_PROJECT_UUID("60434"),PROJECT_NAME_DUPLICATE("60435"),PROJECT_NAME_ASSOCIATED("60436"),DUE_DATE_GRATE_THEN("60437"),
	LENGTH_CHECK("60438"),	SIZE_CHECK("60439"),
	BLANK_PROJECT_DESCRIPTION("60021"),BLANK_PROJECT_STATUS("60305"),

	PHASE_CREATED("60017"), PHASE_CREATATION_FAILED("60018"), PHASE_NAME_IS_BLANK("60019"),
	PHASE_NAME_MAX_SIZE("60020"),PONS_ALREADY_EXIST("60022"),PHASE_UPDATED("60028"),BLANK_PROJECT_FIELDS("60410"),PONS_ALREADY_EXIST_WITH_PHASE("60038"),

	PHASE_NOT_FOUND("60300"), PROJECT_NOT_FOUND("60301"), LINK_DELINK_BLANK("60302"),DELINK_DELINK_BLANK("60337"), DATA_NOT_FOUND("60303"),
	INVALID_STATUS_CODE("60305"), PROJECT_UPDATE_SUCCESS("60306"),BLANK_PROJECT_STATUS_CODE("60307"),

	INVALID_DATA("60400"),

	FIELD_REQUIRED("60410"), STATUS_UPDATED("60411"), FIELD_INVALID_NUMERIC("60412"), PROJECT_CREATED_FAILED("60413"),
	COMMENT_INVALID_LENGTH("60414"), PHASE_CREATED_FAILED("60415"), NO_DATA_FOUND("60416"),

	PROJECT_CREATED("60424"), PROJECT_UPDATED("60425"), PROJECT_UPDATED_FAILED("60426"), COMMENT_UPDATED("60427"),
	FILE_UPLOAD_SUCESS("60428"), UPDATED_FAILED("60429"), ASSIGN_USER("60430"), ERROR_CREATED("60431"),
	CUSTOM_HISTORY_REVERTED("60432"),
	
	UNKNOWN_ERROR("60500"), UNKNOWN_ERROR_WSO2("60501"),
	INVALID_PROJECT_DUE_DATE("60502"),PROJECT_FIELD_KEY_MANDATORY("60503"),PROJECT_FIELD_KEY_MAX_LENGTH("60504"),
	PROJECT_FIELD_KEY_LENGTH_ALLOWED("60505"),
	FILTER_KEY_MANDATORY("60506"),
	FILTER_KEY_BLANK("60507"),
	FILTER_KEY_INVALID("60508"),
	FILTER_OPERATOR_MANDATORY("60509"),
	FILTER_OPERATOR_BLANK("60510"),
	FILTER_OPERATOR_INVALID("60511"),
	FILTER_VALUE_MANDATORY("60512"),
	FILTER_VALUE_BLANK("60513"),
	FILTER_VALUE_NUMERIC_INVALID("60514"),
	PON_VALUE_NUMERIC_INVALID("60029"),
	PON_NOT_LINKED_WITH_SOURCE("60030"),
	SORT_BY_FIELD_MANDATORY("60515"),
	SORT_BY_FIELD_BLANK("60516"),
	SORT_BY_FIELD_INVALID("60517"),
	SORT_BY_ORDER_INVALID("60518"),
	OFFSET_VALUE_INVALID("60519"),
	LIMIT_VALUE_INVALID("60520"),
	OFFSET_VALUE_LIMIT_EXCEED("60521"),
	LIMIT_VALUE_LIMIT_EXCEED("60522"),
	FILTER_SECOND_VALUE_MANDATORY("60523"),
	SOURCE_NAME_INVALID("60031"),
	DESTINATION_NAME_INVALID("60032"),
	PHASE_NAME_ALREADY_EXITS("60033"),
	SOURCE_NAME_MAX_LENGTH("60034"),
	PROJECT_PHASE_UUID_INVALID("60036"),
	DESTINATION_NAME_ALREADY_EXITS("60035"),
	PROJECT_AND_PHASE_INVALID_MAPPING("60039"),
	SOURCE_AND_DESTINATION_SAME("60040");
	
	
	private final String code;

	ResponseStatusCodes(String code) {
		this.code = code;
	}

	public String getMessage(MessageSource messageSource, Object[] args, Locale locale) {
		return messageSource.getMessage(code, args, locale);
	}

	public String getMessage(MessageSource messageSource, Object[] args) {
		return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
	}

	public String getMessage(MessageSource messageSource) {
		return messageSource.getMessage(code, new Object[] {}, LocaleContextHolder.getLocale());
	}
}
