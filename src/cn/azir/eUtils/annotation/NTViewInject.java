/**
 * Copyright 2016/07/12 . kongxs1017@gmail.com

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package cn.azir.eUtils.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NTViewInject {

	int id() default 0;

//	public void onClick(View v)
	String onClick() default "";

//	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	String onItemClick() default "";

//	public boolean onLongClick(View v)
	String onLongClick() default "";

//	public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
	String onItemLongClick() default "";
	
}
