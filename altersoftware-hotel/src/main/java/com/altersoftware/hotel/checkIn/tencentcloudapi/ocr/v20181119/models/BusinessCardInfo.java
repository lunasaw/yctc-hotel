/*
 * Copyright (c) 2017-2018 THL A29 Limited, a Tencent company. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.altersoftware.hotel.checkIn.tencentcloudapi.ocr.v20181119.models;

import java.util.HashMap;

import com.altersoftware.hotel.checkIn.tencentcloudapi.common.AbstractModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusinessCardInfo extends AbstractModel {

    /**
     * 识别出的字段名称（关键字，可能重复，比如多个手机），能识别的字段名为：
     * 姓名、英文姓名、英文地址、公司、英文公司、职位、英文职位、部门、英文部门、手机、电话、传真、社交帐号、QQ、MSN、微信、微博、邮箱、邮编、网址、公司账号、其他。
     */
    @SerializedName("Name")
    @Expose
    private String Name;

    /**
     * 识别出的字段名称对应的值，也就是字段name对应的字符串结果。
     */
    @SerializedName("Value")
    @Expose
    private String Value;

    /**
     * Get 识别出的字段名称（关键字，可能重复，比如多个手机），能识别的字段名为：
     * 姓名、英文姓名、英文地址、公司、英文公司、职位、英文职位、部门、英文部门、手机、电话、传真、社交帐号、QQ、MSN、微信、微博、邮箱、邮编、网址、公司账号、其他。
     *
     * @return Name 识别出的字段名称（关键字，可能重复，比如多个手机），能识别的字段名为：
     * 姓名、英文姓名、英文地址、公司、英文公司、职位、英文职位、部门、英文部门、手机、电话、传真、社交帐号、QQ、MSN、微信、微博、邮箱、邮编、网址、公司账号、其他。
     */
    public String getName() {
        return this.Name;
    }

    /**
     * Set 识别出的字段名称（关键字，可能重复，比如多个手机），能识别的字段名为：
     * 姓名、英文姓名、英文地址、公司、英文公司、职位、英文职位、部门、英文部门、手机、电话、传真、社交帐号、QQ、MSN、微信、微博、邮箱、邮编、网址、公司账号、其他。
     *
     * @param Name 识别出的字段名称（关键字，可能重复，比如多个手机），能识别的字段名为：
     * 姓名、英文姓名、英文地址、公司、英文公司、职位、英文职位、部门、英文部门、手机、电话、传真、社交帐号、QQ、MSN、微信、微博、邮箱、邮编、网址、公司账号、其他。
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * Get 识别出的字段名称对应的值，也就是字段name对应的字符串结果。
     *
     * @return Value 识别出的字段名称对应的值，也就是字段name对应的字符串结果。
     */
    public String getValue() {
        return this.Value;
    }

    /**
     * Set 识别出的字段名称对应的值，也就是字段name对应的字符串结果。
     *
     * @param Value 识别出的字段名称对应的值，也就是字段name对应的字符串结果。
     */
    public void setValue(String Value) {
        this.Value = Value;
    }

    /**
     * Internal implementation, normal users should not use it.
     */
    public void toMap(HashMap<String, String> map, String prefix) {
        this.setParamSimple(map, prefix + "Name", this.Name);
        this.setParamSimple(map, prefix + "Value", this.Value);

    }
}
